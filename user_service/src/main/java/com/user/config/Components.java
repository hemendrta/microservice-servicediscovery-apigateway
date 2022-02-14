package com.user.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Components {

    //creating the bean of RestTemplate to call the contact service from the controller.

    @Bean
//    Load balanced is used to ensure that the client side load balancing is available during the api gateway config.
    @LoadBalanced
    public RestTemplate restTemplate(){

        return new RestTemplate();

    }

}
