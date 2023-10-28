package com.example.web.mvc.dto;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class UserDto {

    public UserDto(){
        birthDate = new Date();
        issueDate = new Date();
    }

    private String id;
    private String name;
    private String password;
    private Integer age;
    private String gender;
    private String race;
    private String imgUrl;
    private String email;
    private String phoneNo;
    private Date birthDate;
    private Date issueDate;
}
