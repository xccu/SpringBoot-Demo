package com.example.demo.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {
    private String id;
    private String name;
    private Integer age;
    private String sex;
    private String email;
    private String tel;
    private int power;
    private String national;
    private String avatarUrl;
}
