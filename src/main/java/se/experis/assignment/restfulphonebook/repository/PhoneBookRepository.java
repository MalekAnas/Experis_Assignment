package se.experis.assignment.restfulphonebook.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import se.experis.assignment.restfulphonebook.model.PhoneBook;


@Repository
public interface PhoneBookRepository extends MongoRepository<PhoneBook, String> {

}
