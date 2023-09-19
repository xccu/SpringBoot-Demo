package com.example.springdata.demo.controller;

import com.example.springdata.demo.model.User;
import com.example.springdata.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    //http://localhost:8080/user/1
    @GetMapping("/user/{id}")
    public Optional<User> queryUserById(@PathVariable("id") Integer id) {
        return userRepository.findById(id);
        //return userRepository.findOne(id);
    }

    @GetMapping("/user")
    public User insertUser(User user) {
        //返回的对象中将会带有自增组件
        return userRepository.save(user);
    }
}