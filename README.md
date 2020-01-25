# Experis_Assignment

## Fixed Requirements
1. It should allow me as a user to upload my old phonebook database which is in XML format. 
2. Http based api using spring boot.

## Assumptions
1. The user can create multiple phonebooks.
2. The user can add a contact to the phone book.
3. The user can add list of contacts to a phone book.
4. The contact has the following properties:
   ~~~java
   public class Contact {
   
    private String name;
    private String surName;
    private String number;
    
    }
    ~~~

## Technologies used:
- Java.
- Spring boot framework.
- NoSql MongoDB.


## API endpoints guide
User can reach to these endpoints by requesting the following URL: http://localhost:8080/api/phone_book
- "/" will return all phone books.
- "/create" accepts POST requests that creates a new phone book. Requires the following parameters in the request body.
   ~~~json
   {
	 "name":"Leo Da Vinci Phone Book",
	 "description":"Phone book of old smart artists!
   }
   ~~~
- "/{phoneBookId}" accepts POST and GET requests. When get requesting this endpoint it will return the phone book with the specifide id,   and when POST requesting this endpoint with the following body, it will add a new contact or a list of contacts to the phone book.
   ~~~json
    {
        "name": "Tanmay Patil",
        "surName": null,
        "number": "(011) 123-4567"
    },
    {
        "name": "Tanmay Patil",
        "surName": null,
        "number": "(011) 123-4567"
    },
    {
        "name": "Tanmay Patil",
        "surName": null,
        "number": "(011) 123-4567"
    },
    {
        "name": "Tanmay Patil",
        "surName": null,
        "number": "(011) 123-4567"
    }
   ~~~
   
   OR
   ~~~XML
	
<contactRequests>
    <contact>
        <name>Tanmay Patil</name>
        <surname>TutorialsPoint</surname>
        <number>(011) 123-4567</number>
    </contact>
    <contact>
        <name>Tanmay Patil</name>
        <surname>TutorialsPoint</surname>
        <number>(011) 123-4567</number>
    </contact>
    <contact>
        <name>Tanmay Patil</name>
        <surname>TutorialsPoint</surname>
        <number>(011) 123-4567</number>
    </contact>
    <contact>
        <name>Tanmay Patil</name>
        <surname>TutorialsPoint</surname>
        <number>(011) 123-4567</number>
    </contact>


</contactRequests>
   ~~~
   
   
