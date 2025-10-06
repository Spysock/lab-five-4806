package org.example.labthree;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface AddressBookRepository extends CrudRepository<AddressBook, Long> {
}