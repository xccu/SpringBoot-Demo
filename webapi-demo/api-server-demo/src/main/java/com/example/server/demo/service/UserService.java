package com.example.server.demo.service;

import com.example.server.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    public List<User> getAll() {
        return getUserList();
    }

    public User getById(int id) {
        return getUserList().stream().filter(t -> t.getId() == id).findFirst().orElse(new User());
    }

    private List<User> getUserList() {
        List<User> userList = new ArrayList<>();
        User user;

        user = new User();
        user.setId(1);
        user.setName("Weslie");
        user.setAge(12);
        user.setSex("male");
        userList.add(user);

        user = new User();
        user.setId(2);
        user.setName("Wolffy");
        user.setAge(34);
        user.setSex("male");
        userList.add(user);

        user = new User();
        user.setId(3);
        user.setName("Tibbie");
        user.setAge(11);
        user.setSex("female");
        userList.add(user);

        user = new User();
        user.setId(4);
        user.setName("Sparky");
        user.setAge(12);
        user.setSex("male");
        userList.add(user);

        user = new User();
        user.setId(5);
        user.setName("Paddi");
        user.setAge(10);
        user.setSex("male");
        userList.add(user);

        return userList;
    }
}
