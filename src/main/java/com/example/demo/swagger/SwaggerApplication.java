package com.example.demo.swagger;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.time.LocalDate;
import java.time.LocalTime;

//参考：https://www.jianshu.com/p/f4fb5e9899fc

@Slf4j
@SpringBootApplication
//@ComponentScan("com.example.demo.swagger.config")
public class SwaggerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwaggerApplication.class, args);
        log.info(
                "======================== started up successfully at {} {} ========================",
                LocalDate.now(),
                LocalTime.now()
        );
    }

}
