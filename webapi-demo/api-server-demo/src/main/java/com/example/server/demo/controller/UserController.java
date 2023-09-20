package com.example.server.demo.controller;


import com.example.server.demo.model.User;
import com.example.server.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 获取所有list，以json形式返回
     * url:"http://localhost:8080/user/getall"
     *
     * @return
     */
    @RequestMapping(value = "/getall")
    public List<User> findAllStudent() {

        return userService.getAll();
    }


    /**
     * 查找 restful 风格
     * url:"http://localhost:8080/user/getbyid/1"
     *
     * @param id
     * @return
     */

    // == @RequestMapping(value = "/user/getbyid/{id}", method = RequestMethod.GET)
    @GetMapping("/getbyid/{id}")
    public User findUserRestful(@PathVariable("id") Integer id) {

        return userService.getById(id);
    }


    /**
     * 删除 restful 风格
     * url:"http://localhost/student/deleteone/4"
     * 注意无法通过浏览器的链接来模拟检验,可以通过 jquery的 $.ajax方法，并type="delete"
     *
     * @param id
     */
    // == @RequestMapping(value = "/deleteone/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/deleteone/{id}")
    public void deleteStudentRestful(@PathVariable("id") Integer id) {

    }


    /**
     * 增加 restful 风格
     * url:"http://localhost:8080/user/adduser"
     * 通过<form>表单模拟验证
     *
     * @param user
     */
    // == @RequestMapping(value="/user/adduser",method=RequestMethod.POST)
    @PostMapping("/adduser")
    public void addStudentRestful(@RequestBody User user) {
        System.out.println("/adduser");
        System.out.println(user);
    }


    /**
     * 修改 restful 风格
     * url:"http://localhost/student/updateone"
     * 验证：可以通过 jquery的 $.ajax方法，并type="put",同时注意data形式——A=a&B=b&C=c
     *
     * @param user
     */
    // == @RequestMapping(value="/addone",method=RequestMethod.PUT)
    @PutMapping("/updateone")
    public void updateUser(@RequestBody User user) {
        System.out.println("/updateone");
        System.out.println(user);
    }

}
