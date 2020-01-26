package se.experis.assignment.restfulphonebook.utils;

import javafx.beans.binding.StringBinding;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;

@Component
public class ContactIdGenerator {

    private final Random RANDOM = new SecureRandom();
    private final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final int ITERATIONS = 10000;
    private final int KEY_LENGTH = 128;


    public String generateContactId(int length){
        return generateRandomString(length);
    }

    private String generateRandomString(int length) {

        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i = 0; i<length; i++){
            stringBuilder.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }

      return new String(stringBuilder);
    }


}
