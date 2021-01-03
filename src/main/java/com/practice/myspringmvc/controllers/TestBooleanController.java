package com.practice.myspringmvc.controllers;

import com.practice.myspringmvc.dtos.TrackCampaign;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestBooleanController {

    @PutMapping("/track-campaign")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "API to track explicit dismissal of banner by user")
    public void testBoolean(@RequestBody TrackCampaign boolRequest) {
        System.out.println(boolRequest);
    }
}
