package com.example.api.controller.request;

import java.io.Serializable;

public class UserReq implements Serializable{

    private static final long serialVersionUID = -4892194063073883735L;

    private String name;
    private Integer age;

    public UserReq(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public UserReq() {
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
}
