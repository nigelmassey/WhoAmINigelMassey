package com.example.WhoAmI.models;

public class WhoAmIResponseModel {

    private final String first_name;
    private final String country_code;
    private final int age;
    private final String gender;

    public WhoAmIResponseModel(String first_name, String country_code, int age, String gender) {
        this.first_name = first_name;
        this.country_code = country_code;
        this.age = age;
        this.gender = gender;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getCountry_code() {
        return country_code;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
}

