package com.example.WhoAmI.services;

import com.example.WhoAmI.models.AgifyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AgifyService {

    private final RestTemplate restTemplate;
    private final String UrlWithName = "https://api.agify.io/?name={first_name}";
    private final String UrlWithNameAndCountryCode = "https://api.agify.io/?name={first_name}&country_id={country_code}";

    public AgifyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public int getAgeFromName(String first_name){

        AgifyModel agifyResult = this.restTemplate.getForObject(UrlWithName, AgifyModel.class, first_name);

        return agifyResult != null ? agifyResult.getAge() : 0;

    }

    public int getAgeFromNameAndLocation(String first_name, String country_code){

        AgifyModel agifyResult = this.restTemplate.getForObject(UrlWithNameAndCountryCode, AgifyModel.class, first_name, country_code);

        return agifyResult != null ? agifyResult.getAge() : 0;

    }

}
