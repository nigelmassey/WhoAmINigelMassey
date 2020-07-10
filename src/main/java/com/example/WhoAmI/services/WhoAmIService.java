package com.example.WhoAmI.services;

import com.example.WhoAmI.models.AgifyModel;
import com.example.WhoAmI.models.GenderizeModel;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WhoAmIService {

    private final RestTemplate restTemplate;
    private final String agifyUrlWithName = "https://api.agify.io/?name={first_name}";
    private final String genderizeUrlWithName = "https://api.agify.io/?name={first_name}";
    private final String agifyUrlWithNameAndCountryCode = "https://api.agify.io/?name={first_name}&country_id={country_code}";
    private final String genderizeUrlWithNameAndCountryCode = "https://api.genderize.io/?name={first_name}&country_id={country_code}";

    public WhoAmIService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public int getAgeFromName(String first_name){

        AgifyModel agifyResult = this.restTemplate.getForObject(agifyUrlWithName, AgifyModel.class, first_name);

        return agifyResult != null ? agifyResult.getAge() : 0;

    }

    public int getAgeFromNameAndLocation(String first_name, String country_code){

        AgifyModel agifyResult = this.restTemplate.getForObject(agifyUrlWithNameAndCountryCode, AgifyModel.class, first_name, country_code);

        return agifyResult != null ? agifyResult.getAge() : 0;

    }

    public String getGenderFromName(String first_name){

        GenderizeModel genderizeResult = this.restTemplate.getForObject(genderizeUrlWithName, GenderizeModel.class);

        return genderizeResult != null ? genderizeResult.getGender() : "n/a";

    }

    public String getGenderFromNameAndLocation(String first_name, String country_code){

        GenderizeModel genderizeResult = this.restTemplate.getForObject(genderizeUrlWithNameAndCountryCode, GenderizeModel.class, first_name, country_code);

        return genderizeResult != null ? genderizeResult.getGender() : "n/a";

    }
}
