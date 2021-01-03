package com.practice.myspringmvc.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.practice.myspringmvc.dtos.Person;
import com.practice.myspringmvc.dtos.Person2;
import com.practice.myspringmvc.services.impl.ObjectMapperDemo;
import com.practice.myspringmvc.services.impl.TestRestCallImpl;
import com.practice.myspringmvc.validator.TestControllerValidator1;
import com.practice.myspringmvc.validator.TestControllerValidator2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URISyntaxException;


/**
 * Random generic controller to play with
 */
@RestController
public class TestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private TestRestCallImpl testRestCall;

    @Autowired
    TestControllerValidator1 testControllerValidator1;

    @Autowired
    TestControllerValidator2 testControllerValidator2;

    @Autowired
    private ObjectMapperDemo objectMapperDemo;

    @InitBinder( "person" )
    public void setValidator1(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(testControllerValidator1);
    }

    @InitBinder( value = "person2" )
    public void setValidator2(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(testControllerValidator2);
    }

    @PostMapping( "/test/post1" )
    public void foo1(@Valid @RequestBody Person person) {
        System.out.println("Landed controller1");
    }

    @PostMapping( "/test/post2" )
    public void foo2(@Valid @RequestBody Person2 person) {
        System.out.println("Landed controller2");
    }

    @GetMapping( value = "/testGet/{id}" )
    public void foo(@PathVariable( value = "id" ) String id) {
        LOGGER.info("value of pathVar = " + id);
        System.out.println("Value of pathVar =" + id);
    }

    @GetMapping( value = "/test/rest" )
    public void testRestCall() throws URISyntaxException {
        testRestCall.callme();
    }

    @GetMapping( value = "/test/object/mapper" )
    public void testObjectMapper() throws JsonProcessingException {
        objectMapperDemo.foo();
    }
}
