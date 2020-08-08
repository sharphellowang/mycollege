package com.example.api.dto;

import java.io.Serializable;

public class UserDTO implements Serializable {

    private static final long serialVersionUID = -4324748203044772470L;

    private Long id;

    private Long name;

    private Integer sex;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getName() {
        return name;
    }

    public void setName(Long name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}