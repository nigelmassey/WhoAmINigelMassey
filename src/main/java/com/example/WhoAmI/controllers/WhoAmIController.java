package com.example.WhoAmI.controllers;

import com.example.WhoAmI.models.WhoAmIRequestModel;
import com.example.WhoAmI.models.WhoAmIResponseModel;
import com.example.WhoAmI.services.AgifyService;
import com.example.WhoAmI.services.GenderizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/whoami")
public class WhoAmIController {

    private final AgifyService agifyService;
    private final GenderizeService genderizeService;

    @Autowired
    public WhoAmIController(AgifyService agifyService, GenderizeService genderizeService) {
        this.agifyService = agifyService;
        this.genderizeService = genderizeService;
    }

    @PostMapping
    public WhoAmIResponseModel whoami(@RequestBody WhoAmIRequestModel whoAmIRequest){

        int age = agifyService.getAgeFromNameAndLocation(whoAmIRequest.getFirst_name(), whoAmIRequest.getCountry_code());
        String gender = genderizeService.getGenderFromNameAndLocation(whoAmIRequest.getFirst_name(), whoAmIRequest.getCountry_code());

        return new WhoAmIResponseModel(
                whoAmIRequest.getFirst_name(),
                whoAmIRequest.getCountry_code(),
                age,
                gender
        );

    }

}
