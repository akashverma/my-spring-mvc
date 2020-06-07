package com.practice.myspringmvc.controllers;

import com.practice.myspringmvc.dtos.Car;
import com.practice.myspringmvc.dtos.RegistrationForm;
import com.practice.myspringmvc.dtos.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@RestController
public class MyController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyController.class);

    @GetMapping(value = "/test")
    public void foo() {
        LOGGER.info("info log printed");
        LOGGER.error("error log printed");
        LOGGER.debug("debug log printed");
        LOGGER.trace("trace log printed");
        LOGGER.warn("warn log printed");
    }

    @PostMapping(value = "/post")
    public void postData(@Valid @RequestBody Car car) {
        LOGGER.info(car.getLicensePlate());
    }

    @PostMapping(value = "/register/user")
    public void registerUser() {
        User user = new User();
        user.setWorking(true);
        user.setAboutMe("Its all about me!");
        user.setAge(50);

        //create a validator programatically by using Factory Pattern
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        //validate and collect set of violations in the user
        Set<ConstraintViolation<User>> violations = validator.validate(user);

        for (ConstraintViolation<User> violation : violations) {
            System.out.println(violation.getMessage());
        }
    }

    @PostMapping(value = "/testPost")
    @ResponseStatus(HttpStatus.CREATED)
        public void saveApplicationAndProductDetails(@RequestBody RegistrationForm registrationForm) {
        System.out.println(registrationForm.getFirstName());
    }

}
