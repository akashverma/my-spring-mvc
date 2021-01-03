package com.practice.myspringmvc.services.impl;

import com.practice.myspringmvc.config.YAMLConfig;
import com.practice.myspringmvc.dtos.FootballDataResponse;
import com.practice.myspringmvc.dtos.TeamData;
import com.practice.myspringmvc.exceptions.ErrorScenario;
import com.practice.myspringmvc.exceptions.MyException;
import com.practice.myspringmvc.services.FootballService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class FootballServiceImpl implements FootballService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private YAMLConfig yamlConfig;

    @Override
    public int getTotalGoals(String team, int year) {
        int totGoalsAsHomeTeam;
        int totGoalsAsAwayTeam;
        int totGoals;

        String baseUrl = yamlConfig.getBaseUrl();
        String finalUrlAsHome = baseUrl + "?" + "year=" + year + "&" + "team1=" + team;
        totGoalsAsHomeTeam = fetchGoals(finalUrlAsHome, true);

        String finalUrlAsAway = baseUrl + "?" + "year=" + year + "&" + "team2=" + team;
        totGoalsAsAwayTeam = fetchGoals(finalUrlAsAway, false);

        totGoals = totGoalsAsHomeTeam + totGoalsAsAwayTeam;

        return totGoals;
    }

    private int fetchGoals(String url, boolean isHome) {

        HttpHeaders headers = null;
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url);
        ResponseEntity<FootballDataResponse> response =
                restTemplate.exchange(uriBuilder.build().toUriString(), HttpMethod.GET, new HttpEntity(headers), FootballDataResponse.class);

        FootballDataResponse dataResponse = response.getBody();

        if (dataResponse == null) {
            throw new MyException("response not Received", ErrorScenario.SERVICE_INVOCATION_FAILURE, "", null);
        }

        int totGoals = 0;
        for (TeamData teamData : dataResponse.getData()) {
            if (isHome) {
                int g = Integer.parseInt(teamData.getTeam1Goals());
                totGoals = totGoals + g;
            } else {
                int g = Integer.parseInt(teamData.getTeam2Goals());
                totGoals = totGoals + g;
            }
        }

        System.out.println("Total goals = " + totGoals);
        return totGoals;
    }
}
