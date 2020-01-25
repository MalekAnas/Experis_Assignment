package se.experis.assignment.restfulphonebook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PhoneBookNotFoundException extends RuntimeException{


    private static final long serialVersionUID = 1L;

    public PhoneBookNotFoundException(String msg) {
        super(msg);
    }
}
