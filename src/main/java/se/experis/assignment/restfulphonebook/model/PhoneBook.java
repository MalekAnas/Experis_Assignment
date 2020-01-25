package se.experis.assignment.restfulphonebook.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
public class PhoneBook {

    @Id
    @Indexed
    private String id;


    private String name;
    private String description;
    private List<Contact> contacts;

}
