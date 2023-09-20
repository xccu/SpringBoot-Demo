package com.example.client.demo.service;

import com.example.client.demo.model.User;
import feign.Param;
import feign.RequestLine;


import java.util.List;

public interface FeignService {

    @RequestLine("GET /user/getall")
    List<User> getAllUsers();

    @RequestLine("GET /user/getbyid/{id}")
    User getUserByID(@Param("id") Integer id);

    @RequestLine("POST /user/adduser")
    void postUser(User user);
}
