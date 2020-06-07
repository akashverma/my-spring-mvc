package com.practice.myspringmvc.dtos;

import com.practice.myspringmvc.services.DriverChecks;
import lombok.AllArgsConstructor;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;

@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
public class Driver extends Person {

    @Min(value = 18, groups = DriverChecks.class, message = "You must be 18 to drive")
    public int age;

    @AssertTrue(groups = DriverChecks.class, message = "You must pass the driving test")
    public boolean hasDrivingLicense;

    public Driver(String name) {
        super(name);
    }

    public void passedDrivingTest(boolean b) {
        hasDrivingLicense = b;
    }
}
