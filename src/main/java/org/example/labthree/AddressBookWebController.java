package org.example.labthree;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class AddressBookWebController {

    @Autowired
    private AddressBookRepository addressBookRepository;


    @GetMapping("/viewAddressBook")
    public String viewAddressBook(@RequestParam("id") Long id, Model model) {

        Optional<AddressBook> optionalBook = addressBookRepository.findById(id);

        if (optionalBook.isPresent()) {
            AddressBook book = optionalBook.get();

            model.addAttribute("addressBook", book);
            model.addAttribute("buddies", book.getBuddies());
        } else {

            model.addAttribute("addressBook", null);
            model.addAttribute("errorMessage", "AddressBook with ID " + id + " not found.");
        }

        return "addressBook";
    }

    @GetMapping("/")
    public String landingPage(Model model) {
        return "Greetings";
    }
}