package com.example.web.mvc.controller;

import com.example.web.mvc.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

        UserDto user = new UserDto();
        user.setId("202002250001");
        user.setName("Weslie");
        user.setAge(12);
        user.setGender("male");
        user.setImgUrl("/avatar/weslie.jpg");
        model.addAttribute("user", user);

        return "index";
    }

}
