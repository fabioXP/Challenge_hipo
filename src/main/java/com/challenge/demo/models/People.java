package com.challenge.demo.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class People {

    private UUID id;
    private String Name;
    private int age;
    private String gender;


    public People(@JsonProperty("id") UUID id,@JsonProperty("name") String name,@JsonProperty("age") int age,@JsonProperty("gender") String gender) {
        this.id=id;
        this.Name = name;
        this.age = age;
        this.gender = gender;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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
