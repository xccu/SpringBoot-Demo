package com.example.security.config;

import com.example.security.filter.TokenAuthFilter;
import com.example.security.filter.TokenLoginFilter;
import com.example.security.security.DefaultPasswordEncoder;
import com.example.security.security.TokenLogoutHandler;
import com.example.security.security.TokenManager;
import com.example.security.security.UnauthEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

//核心配置类
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class TokenWebSecurityConfig extends WebSecurityConfigurerAdapter {

    private TokenManager tokenManager;
    private RedisTemplate redisTemplate;
    private DefaultPasswordEncoder defaultPasswordEncoder;
    private UserDetailsService userDetailsService;

    @Autowired
    public TokenWebSecurityConfig(UserDetailsService userDetailsService, DefaultPasswordEncoder defaultPasswordEncoder,
                                  TokenManager tokenManager, RedisTemplate redisTemplate) {
        this.userDetailsService = userDetailsService;
        this.defaultPasswordEncoder = defaultPasswordEncoder;
        this.tokenManager = tokenManager;
        this.redisTemplate = redisTemplate;
    }

    /**
     * 配置设置
     * @param http
     * @throws Exception
     */
    //设置退出的地址和token，redis操作地址
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.exceptionHandling()
                .authenticationEntryPoint(new UnauthEntryPoint())                       //当没有权限访问时调用未授权统一处理类
                .and().csrf().disable()                                                 //关闭CSRF
                .authorizeRequests()                                                    //授权请求
                .anyRequest().authenticated()                                           //设置所有请求必须经过认证
                .and().logout().logoutUrl("/admin/acl/index/logout")                    //设置退出路径
                .addLogoutHandler(new TokenLogoutHandler(tokenManager,redisTemplate))   //添加退出登录处理类
                .and()
                .addFilter(new TokenLoginFilter(authenticationManager(), tokenManager, redisTemplate)) //添加认证过滤器
                .addFilter(new TokenAuthFilter(authenticationManager(), tokenManager, redisTemplate))  //添加授权过滤器
                .httpBasic();
    }

    //调用userDetailsService和密码处理
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(defaultPasswordEncoder);
    }

    //不进行认证的路径，可以直接访问
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/api/**");
    }
}
