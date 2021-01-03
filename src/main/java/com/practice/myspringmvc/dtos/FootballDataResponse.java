package com.practice.myspringmvc.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@lombok.Getter
@lombok.Setter
public class FootballDataResponse {
    private String total;
    private String page;
    private List<TeamData> data;

    @JsonProperty( "per_page" )
    private String perPage;

    @JsonProperty( "total_pages" )
    private String totalPages;
}
