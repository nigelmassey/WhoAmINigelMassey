package com.example.WhoAmI.services;

import com.example.WhoAmI.models.AgifyModel;
import com.example.WhoAmI.models.GenderizeModel;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WhoAmIService {

    private final RestTemplate restTemplate;

    public WhoAmIService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public int getAgeFromName(String first_name){

        String url = String.format("https://api.agify.io/?name=%s", first_name);

        AgifyModel agifyResult = this.restTemplate.getForObject(url, AgifyModel.class);

        return agifyResult.age;

    }

    public int getAgeFromNameAndLocation(String first_name, String country_code){

        String url = String.format("https://api.agify.io/?name=%s&country_id=%s", first_name, country_code);

        AgifyModel agifyResult = this.restTemplate.getForObject(url, AgifyModel.class);

        return agifyResult.age;

    }

    public String getGenderFromName(String first_name){

        String url = String.format("https://api.genderize.io/?name=%s", first_name);

        GenderizeModel genderizeResult = this.restTemplate.getForObject(url, GenderizeModel.class);

        return genderizeResult.gender;

    }

    public String getGenderFromNameAndLocation(String first_name, String country_code){

        String url = String.format("https://api.genderize.io/?name=%s&country_id=%s", first_name, country_code);

        GenderizeModel genderizeResult = this.restTemplate.getForObject(url, GenderizeModel.class);

        return genderizeResult.gender;

    }
}
