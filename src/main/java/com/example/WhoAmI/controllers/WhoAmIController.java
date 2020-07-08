package com.example.WhoAmI.controllers;

import com.example.WhoAmI.models.WhoAmIModel;
import com.example.WhoAmI.services.WhoAmIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WhoAmIController {

    @Autowired
    private WhoAmIService whoAmIService;

    @PostMapping("/whoami")
    public WhoAmIModel whoami(@RequestBody WhoAmIModel whoAmI){

        whoAmI.setAge(whoAmIService.getAgeFromNameAndLocation(whoAmI.getFirst_name(), whoAmI.getCountry_code()));
        whoAmI.setGender(whoAmIService.getGenderFromNameAndLocation(whoAmI.getFirst_name(), whoAmI.getCountry_code()));
        return whoAmI;

    }

}
