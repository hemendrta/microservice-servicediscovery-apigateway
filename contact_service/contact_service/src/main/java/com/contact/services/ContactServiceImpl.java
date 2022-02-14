package com.contact.services;

import com.contact.entity.Contact;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService{

    List<Contact> contacts=List.of(
            new Contact(121l, "Contact 1", "contact1@gmail.com",1344l),
            new Contact(122l, "Contact 2", "contact2@gmail.com",1344l),
            new Contact(123l, "Contact 3", "contact3@gmail.com",1344l),
            new Contact(124l, "Contact 4", "contact4@gmail.com",1343l),
            new Contact(125l, "Contact 5", "contact5@gmail.com",1343l)
    );

    @Override
    public List<Contact> getContactsOfUser(Long userId) {
        return contacts.stream().filter(contact -> contact.getUserId().equals(userId)).collect(Collectors.toList());
    }
}
