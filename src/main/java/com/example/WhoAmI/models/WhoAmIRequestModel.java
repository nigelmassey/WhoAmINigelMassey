package com.example.WhoAmI.models;

public class WhoAmIRequestModel {

    private final String first_name;
    private final String country_code;

    public WhoAmIRequestModel(String first_name, String country_code) {
        this.first_name = first_name;
        this.country_code = country_code;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getCountry_code() {
        return country_code;
    }
}
