package com.example.WhoAmI.controllers;

import com.example.WhoAmI.models.WhoAmIRequestModel;
import com.example.WhoAmI.models.WhoAmIResponseModel;
import com.example.WhoAmI.services.WhoAmIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/whoami")
public class WhoAmIController {

    private final WhoAmIService whoAmIService;

    @Autowired
    public WhoAmIController(WhoAmIService whoAmIService) {
        this.whoAmIService = whoAmIService;
    }

    @PostMapping
    public WhoAmIResponseModel whoami(@RequestBody WhoAmIRequestModel whoAmIRequest){

        int age = whoAmIService.getAgeFromNameAndLocation(whoAmIRequest.getFirst_name(), whoAmIRequest.getCountry_code());
        String gender = whoAmIService.getGenderFromNameAndLocation(whoAmIRequest.getFirst_name(), whoAmIRequest.getCountry_code());

        return new WhoAmIResponseModel(
                whoAmIRequest.getFirst_name(),
                whoAmIRequest.getCountry_code(),
                age,
                gender
        );

    }

}
