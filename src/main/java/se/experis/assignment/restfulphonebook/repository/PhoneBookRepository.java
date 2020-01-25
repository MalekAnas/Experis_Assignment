package se.experis.assignment.restfulphonebook.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import se.experis.assignment.restfulphonebook.model.PhoneBook;

public interface PhoneBookRepository extends MongoRepository<PhoneBook, String> {
}
