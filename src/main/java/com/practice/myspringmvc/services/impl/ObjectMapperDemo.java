package com.practice.myspringmvc.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.myspringmvc.dtos.OtpAuditDetails;
import org.springframework.stereotype.Service;

@Service
public class ObjectMapperDemo {

    ObjectMapper objectMapper = new ObjectMapper();

    public void foo() throws JsonProcessingException {
        String json = "{" +
                "\"id\" : \"2100001969\", " +
                "\"CUSTOMER_NUMBER\" : \"1444845\" " +
                "}";
        OtpAuditDetails car = objectMapper.readValue(json, OtpAuditDetails.class);
        System.out.println(car.getId());
        System.out.println(car.getCUSTOMER_NUMBER());
        System.out.println(car.getDeviceId());
        System.out.println(car.getDeviceIp());
    }

    public void too(){
        String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
        //Car car = objectMapper.readValue(json, Car.class);
    }
}