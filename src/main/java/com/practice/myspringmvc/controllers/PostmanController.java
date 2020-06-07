package com.practice.myspringmvc.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostmanController {
    @GetMapping("/doGet")
    @ResponseStatus(HttpStatus.OK)
    public void doGet() {
        System.out.println("Get Performed");
    }

    @PutMapping("/doPut")
    @ResponseStatus(HttpStatus.ACCEPTED)//202
    public void doPut() {
        System.out.println("put Performed");
    }

    @PostMapping("/doPost")
    @ResponseStatus(HttpStatus.CREATED)//201
    public void doPost() {
        System.out.println("post Performed");
    }

    @DeleteMapping("/doDelete")
    @ResponseStatus(HttpStatus.NO_CONTENT)//204
    public void doDelete() {
        System.out.println("delete Performed");
    }


    @PatchMapping("/dopatch")
    public void testPatch(){
        System.out.println("patch performed");
    }

    //comment 1
    //comment 2
    //comment 3
}
