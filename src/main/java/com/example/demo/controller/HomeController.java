package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/layui")
public class HomeController {

    //http://localhost:8080/layui/index?id=1
    /*@GetMapping(path = "/index")
    public String index(int id, Model model) {
        return "index";
    }*/

    @GetMapping(path = "/index")
    public String index(int id, Model model){

        User user = new User();
        user.setId("202002250001");
        user.setName("Weslie");
        user.setAge(12);
        user.setSex("male");
        user.setAvatarUrl("/avatar/weslie.jpg");
        model.addAttribute("user", user);

        return "index";
    }

}
