package se.experis.assignment.restfulphonebook.model.request;


import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotNull;

@Data
public class ContactRequest {



    @NotNull
    private String name;
    @NotNull
    private String surName;
    @NotNull
    private String number;

}
