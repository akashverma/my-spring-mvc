package com.practice.myspringmvc.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    /**
     * value annotation can have hardcoded literal as value
     */
    @Value("Hello Akash")
    private String hardCodedgreetingMessage;

    /**
     * or the value annotation can pick the value from property file.
     * via The below syntax
     */
    @Value("${greeting.message}")
    private String genericGreetingMessage;

    @GetMapping("/greeting")
    public String greeting(){
        return genericGreetingMessage;
    }
}
