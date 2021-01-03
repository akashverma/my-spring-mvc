package com.practice.myspringmvc.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@lombok.Setter
@lombok.Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OtpAuditDetails {
    private String id;
    private String CUSTOMER_NUMBER;
    private String deviceId;
    private String deviceIp;
    private String deviceOs;
    private String deviceModel;
    private String otpStatus;
}
