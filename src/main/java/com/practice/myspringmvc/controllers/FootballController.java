package com.practice.myspringmvc.controllers;

import com.practice.myspringmvc.services.impl.FootballServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FootballController {

    @Autowired
    private FootballServiceImpl footballService;

    @GetMapping("/getGoals")
    public void getGoals() {
        System.out.println(footballService.getTotalGoals("Barcelona", 2011));
    }
}
