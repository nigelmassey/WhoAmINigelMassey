package com.example.WhoAmI.models;

public class GenderizeModel {

    private final String name;
    private final String gender;
    private final Double probability;
    private final int count;
    private final String country_id;

    public GenderizeModel(String name, String gender, Double probability, int count, String country_id) {
        this.name = name;
        this.gender = gender;
        this.probability = probability;
        this.count = count;
        this.country_id = country_id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public Double getProbability() {
        return probability;
    }

    public int getCount() {
        return count;
    }

    public String getCountry_id() {
        return country_id;
    }
}
