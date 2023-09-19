package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.model.enums.GenderEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    @Qualifier("datasource")
    private DataSource dataSource;

    /**
     * selectList方法
     * http://localhost:8080/user/connection
     * @return
     */
    @GetMapping("connection")
    public String showConnection() throws SQLException {
        log.info(dataSource.toString());
        Connection conn = dataSource.getConnection();
        log.info(conn.toString());

        return conn.toString();
    }

    /**
     * selectList方法
     * http://localhost:8080/user/selectList
     * @return
     */
    @GetMapping("selectList")
    public List<User> selectListUser(){

        log.info("----- selectList method test ------");
        return userMapper.selectList(null);
    }

    /**
     * queryWrapper方法
     * http://localhost:8080/user/queryWrapper
     * @return
     */
    @GetMapping("queryWrapper")
    public List<User> queryWrapperUser(){
        log.info("----- QueryWrapper test ------");
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.in("id",1,2,3);

        return userMapper.selectList(wrapper);
    }

    /**
     * page方法(需要配置分页插件PaginationInterceptor)
     * http://localhost:8080/user/page
     * @return
     */
    @GetMapping("page")
    public List<User> pageUser(){
        log.info("----- Page test ------");
        //第1页，每页2条记录
        Page<User> page = new Page<User>(1,2);
        IPage<User> iPage = userMapper.selectPage(page, new QueryWrapper());

        log.info("{}",page.getSize());
        log.info("{}",page.getTotal());

        return page.getRecords();
    }

    /**
     * insert方法
     * http://localhost:8080/user/insert
     * @return
     */
    @GetMapping("insert")
    public List<User> insertUser(){
        log.info("----- Insert test ------");

        User user = new User();
        user.setId(10);
        user.setAge(12);
        user.setSex(GenderEnum.MALE);
        user.setName("test");

        int result = userMapper.insert(user);
        log.info("Insert: {}",result);
        return userMapper.selectList(null);
    }

    /**
     * update方法
     * http://localhost:8080/user/update
     * @return
     */
    @GetMapping("update")
    public List<User> updateUser(){
        log.info("----- Update test ------");
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("id",1);

        List<User> users = userMapper.selectList(null);
        User user=users.stream().findFirst().orElse(null);
        user.setAge(10);

        int result = userMapper.update(user,wrapper);
        log.info("Update: {}",result);
        return userMapper.selectList(null);
    }

    /**
     * update方法
     * http://localhost:8080/user/delete
     * @return
     */
    @GetMapping("delete")
    public List<User> deleteUser(){
        log.info("----- Delete test ------");
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("id",1);

        int result = userMapper.delete(wrapper);
        log.info("Delete: {}",result);
        return userMapper.selectList(null);
    }
}
