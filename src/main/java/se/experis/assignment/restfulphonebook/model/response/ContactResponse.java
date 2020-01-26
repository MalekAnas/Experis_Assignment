package se.experis.assignment.restfulphonebook.model.response;

import lombok.Data;

@Data
public class ContactResponse {


    private  String id;
    private String name;
    private String surName;

    private String number;
}
