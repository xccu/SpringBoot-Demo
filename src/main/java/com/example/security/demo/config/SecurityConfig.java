package com.example.security.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()                // 表单登录
                .and()
                .authorizeRequests()    // 认证配置
                .anyRequest()           // 任何请求
                .authenticated();       // 都需要身份验证
    }
}
