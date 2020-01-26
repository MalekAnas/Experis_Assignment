package se.experis.assignment.restfulphonebook.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import se.experis.assignment.restfulphonebook.exception.PhoneBookNotFoundException;
import se.experis.assignment.restfulphonebook.model.Contact;
import se.experis.assignment.restfulphonebook.model.PhoneBook;
import se.experis.assignment.restfulphonebook.model.request.ContactRequest;
import se.experis.assignment.restfulphonebook.model.request.PhoneBookRequest;
import se.experis.assignment.restfulphonebook.model.response.ContactResponse;
import se.experis.assignment.restfulphonebook.model.response.PhoneBookResponse;
import se.experis.assignment.restfulphonebook.service.PhoneBookService;
import se.experis.assignment.restfulphonebook.utils.ContactIdGenerator;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/phone_book")
public class PhoneBookController {


    @Autowired
    private PhoneBookService phoneBookService;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<PhoneBook> getAllPhoneBooks() {

        return phoneBookService.getAll();
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public PhoneBookResponse addPhoneBook(@RequestBody PhoneBookRequest phoneBookRequest) {
        return phoneBookService.createPhoneBook(phoneBookRequest);


    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public PhoneBook getAPhoneBook(@PathVariable String id) {

        PhoneBook returnedPhoneBook = phoneBookService.getPhoneBookById(id);
        if (returnedPhoneBook== null)
            throw new PhoneBookNotFoundException("The phone book is not exist!");
        return returnedPhoneBook;
    }

    @RequestMapping(value = "/{phoneBookId}" , method = RequestMethod.PUT)
    public PhoneBookResponse updatePhoneBook(@PathVariable String phoneBookId, @RequestBody PhoneBookRequest phoneBookRequest){


        return phoneBookService.updatePhoneBook(phoneBookId, phoneBookRequest) ;
    }

    @RequestMapping(value = "/{phoneBookId}", method = RequestMethod.DELETE)
    public void deletePhoneBook(@PathVariable String phoneBookId){
        phoneBookService.deletePhoneBook(phoneBookId);
    }







    @RequestMapping(value = "/{phoneBookId}", method = RequestMethod.POST)
    public ContactResponse addContactToPhoneBook(@PathVariable String phoneBookId, @RequestBody ContactRequest contactRequest) {

        return phoneBookService.addContactToPhoneBook(contactRequest, phoneBookId);
    }


    @RequestMapping(value = "/{phoneBookId}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE)
    public List<ContactResponse> addContactToPhoneBook(@PathVariable String phoneBookId, @RequestBody List<ContactRequest> contactRequests) {

        List<ContactResponse> contactResponses = new ArrayList<>();
        for (ContactRequest contactRequest : contactRequests) {

            contactResponses.add(phoneBookService.addContactToPhoneBook(contactRequest, phoneBookId));
        }
        return contactResponses;
    }

 


}
