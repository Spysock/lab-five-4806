package org.example.labthree;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api")
public class AddressBookController {

    @Autowired
    private AddressBookRepository addressBookRepository;

    @PostMapping("/create/{id}")
    public AddressBook createAddressBook(@PathVariable("id") Integer id) {
        AddressBook addressBook = new AddressBook(id);
        return addressBookRepository.save(addressBook);
    }

    @PostMapping("/{id}/add/{name}/{phoneNumber}")
    public AddressBook addBuddy(@PathVariable("id") Long id, @PathVariable("name") String name, @PathVariable("phoneNumber") String phoneNumber) {
        BuddyInfo buddyInfo = new BuddyInfo(name, phoneNumber);
        AddressBook addressBook = addressBookRepository.findById(id).orElseThrow();

        addressBook.addBuddy(buddyInfo);
        return addressBookRepository.save(addressBook);
    }

    @DeleteMapping("/{id}/remove/{phoneNumber}")
    public void removeBuddy(@PathVariable("id") Long id, @PathVariable("phoneNumber") String phoneNumber) {
        AddressBook addressBook = addressBookRepository.findById(id).orElseThrow();

        addressBook.removeBuddy(phoneNumber);
        addressBookRepository.save(addressBook);
    }
}
