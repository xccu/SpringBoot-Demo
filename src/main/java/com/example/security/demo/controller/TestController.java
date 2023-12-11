package com.example.security.demo.controller;

import com.example.security.demo.entity.User;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("hello")
    //@Secured({"admin","ROLE_sale"})
    public String hello() {
        return "hello security";
    }

    @GetMapping("index")
    @Secured({"admin","ROLE_sale"})  //测试注解
    public String index() {
        return "hello index";
    }

    @GetMapping("update")
    //@Secured({"ROLE_sale","ROLE_manager"})
    //@PreAuthorize("hasAnyAuthority('admin')")
    @PostAuthorize("hasAnyAuthority('admin')")
    public String update() {
        System.out.println("update......");
        return "hello update";
    }

    @GetMapping("getAll")
    @PostAuthorize("hasAnyAuthority('admin')")
    @PostFilter("filterObject.username == 'admin1'")
    public List<User> getAllUser(){
        ArrayList<User> list = new ArrayList<>();
        //list.add(new User(11,"admin1","6666"));
        //list.add(new User(21,"admin2","888"));
        System.out.println(list);
        return list;
    }


}
