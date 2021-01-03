package com.practice.myspringmvc.validator;

import com.practice.myspringmvc.dtos.Person;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.ConstraintViolation;
import java.util.Set;

@Component
public class TestControllerValidator2 implements Validator {

    private final javax.validation.Validator validator;

    public TestControllerValidator2(javax.validation.Validator validator) {
        this.validator = validator;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.isAssignableFrom(clazz);
    }

    @SneakyThrows
    @Override
    public void validate(Object target, Errors errors) {
        Person request = (Person) target;
        Set<ConstraintViolation<Person>> violations = validator.validate(request);
        if (!violations.isEmpty()) {
            throw new Exception();
        }
    }
}
