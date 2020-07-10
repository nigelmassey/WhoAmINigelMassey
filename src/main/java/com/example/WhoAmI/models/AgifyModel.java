package com.example.WhoAmI.models;

public class AgifyModel {

    private final String name;
    private final int age;
    private final int count;
    private final String country_id;

    public AgifyModel(String name, Integer age, int count, String country_id) {
        this.name = name;
        this.age = age;
        this.count = count;
        this.country_id = country_id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getCount() {
        return count;
    }

    public String getCountry_id() {
        return country_id;
    }
}
