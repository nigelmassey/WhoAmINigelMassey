package com.example.WhoAmI.services;

import com.example.WhoAmI.models.GenderizeModel;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GenderizeService {

    private final RestTemplate restTemplate;
    private final String UrlWithName = "https://api.genderize.io/?name={first_name}";
    private final String UrlWithNameAndCountryCode = "https://api.genderize.io/?name={first_name}&country_id={country_code}";

    public GenderizeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getGenderFromName(String first_name){

        GenderizeModel genderizeResult = this.restTemplate.getForObject(UrlWithName, GenderizeModel.class, first_name);

        return genderizeResult != null ? genderizeResult.getGender() : "n/a";

    }

    public String getGenderFromNameAndLocation(String first_name, String country_code){

        GenderizeModel genderizeResult = this.restTemplate.getForObject(UrlWithNameAndCountryCode, GenderizeModel.class, first_name, country_code);

        return genderizeResult != null ? genderizeResult.getGender() : "n/a";

    }

}
