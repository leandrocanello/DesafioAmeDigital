package com.Ame.DesafioAmeDigital.services;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class PlanetService {

    @Autowired
    private RestTemplate restTemplate;

    public Integer qtdApparition(String planetName) {
        int count = 0;
        ResponseEntity<Map> planetsResponse =
                restTemplate.getForEntity("https://swapi.dev/api/planets/", Map.class);
        if (planetsResponse.getStatusCode() == HttpStatus.OK) {
            JSONObject planetsObject = new JSONObject(planetsResponse.getBody());
            JSONArray planetsArray = planetsObject.getJSONArray("results");

            for (int i = 0; i < planetsArray.length(); i++) {
                JSONObject planetObject = planetsArray.getJSONObject(i);
                String currentPlanetName = planetObject.getString("name");

                if (planetName.equals(currentPlanetName)) {
                    JSONArray filmsArray = planetObject.getJSONArray("films");
                    count = filmsArray.length();
                    break;
                }
            }
        }
        return count;
    }
}
