package com.example.demo.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 柱状图
 */
@Controller
@RequestMapping("/bar")
public class BarController {

    /**
     * http://localhost:8090/bar/demo1
     * @return
     */
    @GetMapping(path = "/demo1")
    public String demo1() {
        return "bar/bar-demo-1";
    }
}
