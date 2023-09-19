package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 配置viewController，为视图提供便捷的路径映射(不用创建Controller)
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        //http://localhost:8080/layui
        registry.addViewController("/layui").setViewName("admin");

        //http://localhost:8080/layui/button
        registry.addViewController("/layui/button").setViewName("element/button");
        //http://localhost:8080/layui/form
        registry.addViewController("/layui/form").setViewName("element/form");
        //http://localhost:8080/layui/nav
        registry.addViewController("/layui/nav").setViewName("element/nav");
        //http://localhost:8080/layui/icon
        registry.addViewController("/layui/icon").setViewName("element/icon");
        //http://localhost:8080/layui/badge
        registry.addViewController("/layui/badge").setViewName("element/badge");
        //http://localhost:8080/layui/progress
        registry.addViewController("/layui/progress").setViewName("element/progress");
        //http://localhost:8080/layui/auxiliar
        registry.addViewController("/layui/auxiliar").setViewName("element/auxiliar");
        //http://localhost:8080/layui/panel
        registry.addViewController("/layui/panel").setViewName("element/panel");
        //http://localhost:8080/layui/tab
        registry.addViewController("/layui/tab").setViewName("element/tab");
        //http://localhost:8080/layui/anim
        registry.addViewController("/layui/anim").setViewName("element/anim");

        //http://localhost:8080/layui/layer
        registry.addViewController("/layui/layer").setViewName("modules/layer");
        //http://localhost:8080/layui/laydate
        registry.addViewController("/layui/laydate").setViewName("modules/laydate");
        //http://localhost:8080/layui/table
        registry.addViewController("/layui/table").setViewName("modules/table");
        //http://localhost:8080/layui/upload
        registry.addViewController("/layui/upload").setViewName("modules/upload");
        //http://localhost:8080/layui/code
        registry.addViewController("/layui/code").setViewName("modules/code");


        //http://localhost:8080/layui/users
        registry.addViewController("/layui/user").setViewName("application/users-table");
        //http://localhost:8080/layui/user-ajax？1
        registry.addViewController("/layui/user-ajax").setViewName("application/user-ajax");
        //http://localhost:8080/layui/idCard
        registry.addViewController("/layui/idCard").setViewName("application/idCard");
        //http://localhost:8080/layui/idCard
        registry.addViewController("/layui/idCard-shell").setViewName("application/idCard-shell");
    }
}

