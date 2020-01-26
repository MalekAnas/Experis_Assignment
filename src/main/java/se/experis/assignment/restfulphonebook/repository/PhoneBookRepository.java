package se.experis.assignment.restfulphonebook.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import se.experis.assignment.restfulphonebook.model.Contact;
import se.experis.assignment.restfulphonebook.model.PhoneBook;

import java.util.List;


@Repository
public interface PhoneBookRepository extends MongoRepository<PhoneBook, String> {


}
