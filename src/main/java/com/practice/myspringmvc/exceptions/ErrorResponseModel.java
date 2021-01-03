package com.practice.myspringmvc.exceptions;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.FieldError;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(description = "Model representing the error response.")
public class ErrorResponseModel {

    @ApiModelProperty(notes = "Identifier for the base error cause.", required = true)
    private ErrorScenario code;

    @ApiModelProperty(notes = "Gives insight of what went wrong to the request we made to an external service.")
    private String vendorStatus;

    @ApiModelProperty(notes = "Describes the error in greater details. It also holds the tracking information.")
    private String desc;

    @ApiModelProperty(notes = "Usage: Form validations at server. Suggests why server rejected a particular form path /attribute.")
    private List<FieldError> fieldErrors;

    @ApiModelProperty(notes = "Timestamp when the particular error occurred.")
    private LocalDateTime timestamp = LocalDateTime.now();



}
