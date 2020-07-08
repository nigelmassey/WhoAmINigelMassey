package com.example.WhoAmI.models;

public class AgifyModel {

    public String name;
    public Integer age;
    public Long count;
    public String country_id;

    public AgifyModel() {
    }

    public AgifyModel(String name, Integer age, Long count, String country_id) {
        this.name = name;
        this.age = age;
        this.count = count;
        this.country_id = country_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getCountry_id() {
        return country_id;
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }
}
