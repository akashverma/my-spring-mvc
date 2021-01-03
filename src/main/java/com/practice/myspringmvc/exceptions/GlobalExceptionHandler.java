package com.practice.myspringmvc.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler( HttpClientErrorException.class )
    public final ResponseEntity<ErrorResponseModel> handleCoverCardServiceException(HttpClientErrorException ex) {
        LOGGER.error("Got Http Client Error Exception.", ex);
        ErrorResponseModel response = new ErrorResponseModel();
        response.setDesc(ex.getMessage());
        response.setVendorStatus(ex.getResponseBodyAsString());
        return serviceErrorResponse(response);
    }

    @ExceptionHandler( RestClientException.class )
    public final ResponseEntity<ErrorResponseModel> handleCoverCardServiceException(RestClientException ex) {
        LOGGER.error("Got Http Client Error Exception.", ex);
        ErrorResponseModel response = new ErrorResponseModel();
        response.setDesc(ex.getMessage());
        return serviceErrorResponse(response);
    }

    @ExceptionHandler( RestClientResponseException.class )
    public final ResponseEntity<ErrorResponseModel> handleCoverCardServiceException(RestClientResponseException ex) {
        LOGGER.error("Got Http Client Error Exception.", ex);
        ErrorResponseModel response = new ErrorResponseModel();
        response.setDesc(ex.getMessage());
        return serviceErrorResponse(response);
    }

    @ExceptionHandler( MyException.class )
    public final ResponseEntity<ErrorResponseModel> handleCoverCardServiceException(MyException ex) {
        LOGGER.error("Got My Custom Exception.", ex);
        ErrorResponseModel response = new ErrorResponseModel();
        response.setDesc(ex.getMessage());
        response.setVendorStatus(ex.getVendorStatus());
        return serviceErrorResponse(response);
    }

    private static ResponseEntity<ErrorResponseModel> serviceErrorResponse(ErrorResponseModel errorResponse) {
        return new ResponseEntity<>(errorResponse, errorResponse.getCode().getHttpStatus());
    }
}
