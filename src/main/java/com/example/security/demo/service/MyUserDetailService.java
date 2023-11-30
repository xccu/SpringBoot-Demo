package com.example.security.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.example.security.demo.entity.User;
import com.example.security.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("myUserDetailsService")
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //调用UserMapper方法查询数据库
        QueryWrapper<User> wrapper = new QueryWrapper();
        wrapper.eq("name",username);
        User user = userMapper.selectOne(wrapper);
        if(user == null){
            throw new UsernameNotFoundException("user not found");
        }

        //权限
        List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList("role");
       return new org.springframework.security.core.userdetails.User(user.getName(), new BCryptPasswordEncoder().encode(user.getPassword()),auths);
    }
}
