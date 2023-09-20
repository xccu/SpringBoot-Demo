package com.example.server.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ApiServerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiServerDemoApplication.class, args);
    }


    //利用@RequestMapping配置url和方法之间的映射
    @RequestMapping("/hello")
    public String hello() {
        return "Hello Weslie!";
    }

}
