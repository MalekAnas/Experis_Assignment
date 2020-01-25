package se.experis.assignment.restfulphonebook.service;

import se.experis.assignment.restfulphonebook.model.Contact;
import se.experis.assignment.restfulphonebook.model.PhoneBook;
import se.experis.assignment.restfulphonebook.model.request.ContactRequest;
import se.experis.assignment.restfulphonebook.model.request.PhoneBookRequest;
import se.experis.assignment.restfulphonebook.model.response.ContactResponse;
import se.experis.assignment.restfulphonebook.model.response.PhoneBookResponse;

import java.util.List;

public interface PhoneBookService {

    List<PhoneBook> getAll();
    PhoneBookResponse createPhoneBook(PhoneBookRequest phoneBookRequest);
    PhoneBook getPhoneBookById(String id);
    ContactResponse addContactToPhoneBook(ContactRequest contactRequest, String phoneBookId);


}
