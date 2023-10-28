package com.xccu.web.api.bootapi.controller;

import com.xccu.web.api.bootapi.entity.User;
import com.xccu.web.api.bootapi.mapper.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "UserController", tags = { "用户接口" })
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    /**
     * 获取所有list，以json形式返回
     * url:"http://localhost:8080/user/getall"
     *
     * @return
     */
    @ApiOperation(value = "获取所有用户")
    @GetMapping(value = "/getall")
    public List<User> getAll() {
        return userMapper.selectList(null);
    }
}
