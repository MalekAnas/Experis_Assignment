package se.experis.assignment.restfulphonebook.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.experis.assignment.restfulphonebook.exception.ContactNotFoundException;
import se.experis.assignment.restfulphonebook.exception.PhoneBookNotFoundException;
import se.experis.assignment.restfulphonebook.model.Contact;
import se.experis.assignment.restfulphonebook.model.PhoneBook;
import se.experis.assignment.restfulphonebook.model.request.ContactRequest;
import se.experis.assignment.restfulphonebook.model.request.PhoneBookRequest;
import se.experis.assignment.restfulphonebook.model.response.ContactResponse;
import se.experis.assignment.restfulphonebook.model.response.PhoneBookResponse;
import se.experis.assignment.restfulphonebook.repository.PhoneBookRepository;
import se.experis.assignment.restfulphonebook.utils.ContactIdGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PhoneBookServiceImpl implements PhoneBookService {

    @Autowired
    private PhoneBookRepository phoneBookRepository;
    @Autowired
    private ContactIdGenerator contactIdGenerator;


    @Override
    public List<PhoneBook> getAll() {
        return phoneBookRepository.findAll();
    }

    @Override
    public PhoneBookResponse createPhoneBook(PhoneBookRequest phoneBookRequest) {
        PhoneBookResponse phoneBookResponse = new PhoneBookResponse();

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.setContacts(new ArrayList<>());
        BeanUtils.copyProperties(phoneBookRequest, phoneBook);

        phoneBookRepository.save(phoneBook);

        BeanUtils.copyProperties(phoneBook, phoneBookResponse);

        return phoneBookResponse;


    }

    @Override
    public PhoneBook getPhoneBookById(String id) {
        Optional<PhoneBook> myPhoneBook = phoneBookRepository.findById(id);
        if (myPhoneBook.isPresent())
            return myPhoneBook.get();

        return null;
    }

    @Override
    public ContactResponse addContactToPhoneBook(ContactRequest contactRequest, String phoneBookId) {
        Optional<PhoneBook> phoneBookOptional = phoneBookRepository.findById(phoneBookId);
        if (!phoneBookOptional.isPresent()) {
            throw new PhoneBookNotFoundException("The phoneBook is not exist!");
        }

        PhoneBook phoneBook = phoneBookOptional.get();
        Contact contact = new Contact();
        contact.setId(contactIdGenerator.generateContactId(30));
        BeanUtils.copyProperties(contactRequest, contact);
        phoneBook.getContacts().add(contact); //todo fix it with better solution
        phoneBookRepository.save(phoneBook);


        ContactResponse contactResponse = new ContactResponse();
        BeanUtils.copyProperties(contact, contactResponse);


        return contactResponse;

    }

    @Override
    public void deletePhoneBook(String id) {

        Optional<PhoneBook> phoneBookOptional = phoneBookRepository.findById(id);
        if (phoneBookOptional.isEmpty())
            throw new PhoneBookNotFoundException("This phone book with the given id is not exist!");
        PhoneBook phoneBook = phoneBookOptional.get();
        phoneBookRepository.delete(phoneBook);

    }

    @Override
    public PhoneBookResponse updatePhoneBook(String id, PhoneBookRequest phoneBookRequest) {

        Optional<PhoneBook> phoneBookOptional = phoneBookRepository.findById(id);
        if (phoneBookOptional.isEmpty())
            throw new PhoneBookNotFoundException("The Phone book with given id is not exist!");
        PhoneBook phoneBook = phoneBookOptional.get();
        BeanUtils.copyProperties(phoneBookRequest, phoneBook);
        phoneBookRepository.save(phoneBook);
        PhoneBookResponse phoneBookResponse = new PhoneBookResponse();
        BeanUtils.copyProperties(phoneBook, phoneBookResponse);
        return phoneBookResponse;
    }




}
