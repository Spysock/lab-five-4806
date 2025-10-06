package org.example.labthree;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BuddyInfo {
    private String name;

    @Id
    private String phoneNumber;

    public BuddyInfo() {}

    public BuddyInfo(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return name + " " + phoneNumber;
    }
}
