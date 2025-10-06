package org.example.labthree;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LabThreeApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabThreeApplication.class, args);
    }

    @Bean
    public CommandLineRunner showAddressBook(AddressBookRepository addressBookRepository) {

        return (args) -> {
            BuddyInfo buddy1 = new BuddyInfo("Bob", "613-123-4567");
            BuddyInfo buddy2 = new BuddyInfo("Steven", "613-891-0111");

            AddressBook addressBook = new AddressBook(1);
            addressBook.addBuddy(buddy1);
            addressBook.addBuddy(buddy2);

            addressBookRepository.save(addressBook);

            for (AddressBook addressBook1 : addressBookRepository.findAll()) {
                System.out.println(addressBook1.getBuddies().toString());
            }
        };
    }
}
