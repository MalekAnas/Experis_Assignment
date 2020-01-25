package se.experis.assignment.restfulphonebook.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import se.experis.assignment.restfulphonebook.model.Contact;

public interface ContactsRepository extends MongoRepository<Contact, String> {
}
