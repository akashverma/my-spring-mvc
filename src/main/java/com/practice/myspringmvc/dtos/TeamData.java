package com.practice.myspringmvc.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

@lombok.Getter
public class TeamData {

    private String competition;
    private String year;
    private String round;
    private String team1;
    private String team2;

    @JsonProperty( "team1goals" )
    private String team1Goals;

    @JsonProperty( "team2goals" )
    private String team2Goals;



    /*
          * "competition": "UEFA Champions League",
            "year": 2011,
            "round": "GroupH",
            "team1": "Barcelona",
            "team2": "AC Milan",
            "team1goals": "2",
            "team2goals": "2"*/
}
