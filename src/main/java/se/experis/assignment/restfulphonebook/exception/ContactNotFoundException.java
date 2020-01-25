package se.experis.assignment.restfulphonebook.exception;

public class ContactNotFoundException extends RuntimeException {


    private static final long serialVersionUID = 1L;

    public ContactNotFoundException(String msg) {
        super(msg);
    }
}
