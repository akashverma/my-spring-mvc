package com.practice.myspringmvc.services;

import com.practice.myspringmvc.dtos.User;
import com.practice.myspringmvc.interfaces.Akash;
import org.springframework.stereotype.Component;

//@Akash
@Component
public class TestService {
    public void fooBar(){
        System.out.println("In akash annotated class");

        User user = new User();
        //test comment
    }
}
