package se.experis.assignment.restfulphonebook.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
public class Contact {


    @Id
    private String id;
    private String name;
    private String surName;

    private String number;


}
