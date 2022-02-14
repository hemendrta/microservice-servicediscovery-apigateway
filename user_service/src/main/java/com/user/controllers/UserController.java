package com.user.controllers;

import com.user.entity.Contact;
import com.user.entity.User;
import com.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") Long userId) {

        //fetching the details of user which we have in the database.

        User user = userService.getUser(userId);

        //We will now call the contact service to get the details of the contact corresponding to the userId which we have.

        //if we are not using service discovery then in that case we must hardcode the url as mentioned with the host and port number

        /*

             List contacts = restTemplate.getForObject("http://localhost:9002/contact/user/" + user.getUserId(), List.class);

         */

        //once we have configured the service discovery then in that case the mentioned will be work. We have configured the hostname and port in the eureka server.

        List contacts = restTemplate.getForObject("http://contact-service/contact/user/" + user.getUserId(), List.class);

        //we have the contacts corresponding to the userId and now we will store them in the user object.

        user.setContacts(contacts);

        return user;

    }

}
