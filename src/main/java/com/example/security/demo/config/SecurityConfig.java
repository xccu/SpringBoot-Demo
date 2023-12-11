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


    @Override
    protected void configure(HttpSecurity http) throws Exception {
       /* http.formLogin()                // 表单登录
                .and()
                .authorizeRequests()    // 认证配置
                .anyRequest()           // 任何请求
                .authenticated();       // 都需要身份验证*/

        //退出
        http.logout().logoutUrl("/logout").
                logoutSuccessUrl("/test/hello").permitAll();    //退出后跳转路径

        //配置没有权限访问跳转自定义页面
        http.exceptionHandling().accessDeniedPage("/unauth.html");
        http.formLogin()                                                            //自定义自己编写的登录页面
                .loginPage("/login.html")                                           //登录页面设置
                .loginProcessingUrl("/user/login")                                  //登录访问路径
                .defaultSuccessUrl("/success.html").permitAll()                     //登录成功之后，跳转路径
                .failureUrl("/unauth.html")                                         //登录失败之后，跳转路径
                .and().authorizeRequests()
                .antMatchers("/","/user/login").permitAll();            //设置哪些路径可以直接访问，不需要认证
                //.anyRequest().authenticated()                                     //所有请求权限开启
                //当前登录用户，只有具有admins权限才可以访问这个路径
                //.antMatchers("/test/index").hasAuthority("admin")    // 1 hasAuthority方法
                //.antMatchers("/test/index").hasAnyAuthority("admin,manager")  // 2 hasAnyAuthority方法
                //.antMatchers("/test/index").hasRole("sale")         // 3 hasRole方法   ROLE_sale

        http.csrf().disable();  //关闭跨站请求伪造（csrf）保护功能

    }
}
