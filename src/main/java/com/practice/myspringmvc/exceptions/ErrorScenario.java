package com.practice.myspringmvc.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorScenario {

    UNKNOWN(HttpStatus.INTERNAL_SERVER_ERROR),
    NOT_IMPLEMENTED(HttpStatus.NOT_IMPLEMENTED),
    BAD_REQUEST(HttpStatus.BAD_REQUEST),
    NOT_FOUND(HttpStatus.NOT_FOUND),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR),
    UNAUTHORIZED(HttpStatus.PRECONDITION_FAILED),
    SERVICE_UNAVAILABLE(HttpStatus.SERVICE_UNAVAILABLE),
    SERVICE_INVOCATION_FAILURE(HttpStatus.INTERNAL_SERVER_ERROR),
    CONTRACTS_EXPIRED(HttpStatus.BAD_REQUEST),
    VALIDATION_FAILURE(HttpStatus.BAD_REQUEST),
    NOT_YET_AVAILABLE(HttpStatus.NOT_FOUND),
    INVALID_QR_CODE(HttpStatus.BAD_REQUEST),
    FORBIDDEN(HttpStatus.FORBIDDEN);

    private HttpStatus httpStatus;

}
