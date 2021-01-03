package com.practice.myspringmvc.exceptions;

import lombok.AllArgsConstructor;
import org.springframework.validation.FieldError;

import java.util.List;

@lombok.Getter
@lombok.ToString
public class MyException extends RuntimeException {

    private static final long serialVersionUID = 7263684210348341559L;

    private final String operation;
    private final ErrorScenario scenario;
    private final String vendorStatus;
    private final List<FieldError> fieldErrors;


    @lombok.Builder
    public MyException(String operation, ErrorScenario scenario, String vendorStatus, List<FieldError> fieldErrors) {
        this.operation = operation;
        this.scenario = scenario;
        this.vendorStatus = vendorStatus;
        this.fieldErrors = fieldErrors;
    }
}
