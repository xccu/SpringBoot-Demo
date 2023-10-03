package com.example.demo.swagger.service;

import com.example.demo.swagger.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {


    private List<User> getUserList(){
        List<User> userList = new ArrayList<>();
        User user;

        user = new User();
        user.setUserId(1);
        user.setName("Weslie");
        user.setAge(12);
        user.setSex("male");
        userList.add(user);

        user = new User();
        user.setUserId(2);
        user.setName("Wolffy");
        user.setAge(34);
        user.setSex("male");
        userList.add(user);

        user = new User();
        user.setUserId(3);
        user.setName("Tibbie");
        user.setAge(11);
        user.setSex("female");
        userList.add(user);

        user = new User();
        user.setUserId(4);
        user.setName("Sparky");
        user.setAge(12);
        user.setSex("male");
        userList.add(user);

        user = new User();
        user.setUserId(5);
        user.setName("Paddi");
        user.setAge(10);
        user.setSex("male");
        userList.add(user);

        return userList;
    }

    public List<User> getUsers(){
        return getUserList();
    }

    public User getUser(int id){
        return getUserList().stream().filter(t->t.getUserId().equals(id)).findFirst().get();
    }

}
