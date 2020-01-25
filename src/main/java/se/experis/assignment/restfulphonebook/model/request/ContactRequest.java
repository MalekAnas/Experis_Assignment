package se.experis.assignment.restfulphonebook.model.request;


import lombok.Data;

@Data
public class ContactRequest {



    private String name;
    private String surName;

    private String number;

}
