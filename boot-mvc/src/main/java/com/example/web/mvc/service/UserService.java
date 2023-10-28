package com.example.web.mvc.service;


import com.example.web.mvc.dto.UserDto;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface UserService {

    @RequestLine("GET /user/getall")
    List<UserDto> getAllUsers();

    @RequestLine("GET /user/getbyid/{id}")
    UserDto getUserByID(@Param("id") Integer id);

    @RequestLine("POST /user/adduser")
    void postUser(UserDto user);
}
