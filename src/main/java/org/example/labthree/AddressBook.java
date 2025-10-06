package org.example.labthree;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {

    @Id
    private Integer addressBookId;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<BuddyInfo> buddies = new ArrayList<>();

    public AddressBook() {}

    public AddressBook(Integer addressBookId) {
        this.addressBookId = addressBookId;
    }

    public void addBuddy(BuddyInfo buddy){
        buddies.add(buddy);
    }

    public void removeBuddy(String phoneNumber){
        System.out.println("I reached the function");
        for (BuddyInfo buddy : this.buddies) {
            if (buddy.getPhoneNumber().equals(phoneNumber)) {
                buddies.remove(buddy);
                System.out.println("Deleted");
                break;
            }
        }
    }

    public List<BuddyInfo> getBuddies() {
        return buddies;
    }

    public BuddyInfo getBuddy(String phoneNumber) {
        for (BuddyInfo buddy : this.buddies) {
            if (buddy.getPhoneNumber().equals(phoneNumber)) {
                return buddy;
            }
        }
        return null;
    }

    public Integer getAddressBookId() {
        return addressBookId;
    }

    public void setAddressBookId(Integer addressBookId) {
        this.addressBookId = addressBookId;
    }

    public static void main(String[] args) {
        BuddyInfo buddy1 = new BuddyInfo("Bob", "613-123-4567");
        BuddyInfo buddy2 = new BuddyInfo("Steven", "613-891-0111");

        AddressBook addressBook = new AddressBook(123);
        addressBook.addBuddy(buddy1);
        addressBook.addBuddy(buddy2);

        System.out.println(addressBook.getBuddies());

    }
}