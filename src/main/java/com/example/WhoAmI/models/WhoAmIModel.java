package com.example.WhoAmI.models;

public class WhoAmIModel {

    private String first_name;
    private String country_code;
    private int age;
    private String gender;

    public WhoAmIModel(String first_name, String country_code, int age, String gender) {
        this.first_name = first_name;
        this.country_code = country_code;
        this.age = age;
        this.gender = gender;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

