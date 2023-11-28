package com.example.security.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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

    @Bean
    PasswordEncoder Encoder(){
        return new BCryptPasswordEncoder();
    }


    @Autowired
    private UserDetailsService myUserDetailsService;

    //配置类设置用户名密码
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        /*//密码加密
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = encoder.encode("123456");
        //配置用户名，密码，权限
        auth.inMemoryAuthentication().withUser("admin").password(password).roles("admin");*/

        //自定义编写实现类
        auth.userDetailsService(myUserDetailsService).passwordEncoder(Encoder());
    }
}
