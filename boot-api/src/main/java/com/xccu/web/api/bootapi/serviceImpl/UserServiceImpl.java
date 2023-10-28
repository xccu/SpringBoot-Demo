package com.xccu.web.api.bootapi.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xccu.web.api.bootapi.entity.User;
import com.xccu.web.api.bootapi.mapper.UserMapper;
import com.xccu.web.api.bootapi.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
