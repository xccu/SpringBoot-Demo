
package com.example.demo.swagger.controller;

import com.example.demo.swagger.entity.User;
import com.example.demo.swagger.service.UserService;
import com.example.demo.swagger.vo.ResultListVO;
import com.example.demo.swagger.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

//访问网址：
//http://localhost:8080/swagger-ui.html#/

@RestController
@Api(value = "UserController", tags = { "用户接口" })
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * get请求
     * @return
     */
    @GetMapping("/all")
    @ApiOperation(value = "获取所有用户")
    @ApiResponses(value = {
            @ApiResponse(code = 1000, message = "成功"),
            @ApiResponse(code = 1001, message = "失败"),
            @ApiResponse(code = 1002, message = "缺少参数")})
    public ResultListVO getAll() {
        ResultListVO vo = new ResultListVO();
        List<User> users =userService.getUsers();
        vo.setUsers(users);
        vo.setCode(200);
        vo.setErrorMsg("");
        return vo;
    }

    /**
     * get请求带参数
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据Id获取用户")
    @ApiResponses(value = {
            @ApiResponse(code = 1000, message = "成功"),
            @ApiResponse(code = 1001, message = "失败"),
            @ApiResponse(code = 1002, message = "缺少参数")})
    @ApiImplicitParam(name = "id", value = "用户ID", dataType = "Integer", paramType = "path", required = true)
    public ResultVO getUser(@PathVariable Integer id) {
        ResultVO vo = new ResultVO();
        User user =userService.getUser(id);
        vo.setUser(user);
        vo.setCode(200);
        vo.setErrorMsg("");
        return vo;
    }

    /**
     * post请求（参数）
     * @param userId
     * @param name
     * @param sex
     * @param age
     * @return
     */
    @ApiOperation(value = "添加用户(参数)")
    @PostMapping("/addParams")
    @ApiResponses(value = {
            @ApiResponse(code = 1000, message = "成功"),
            @ApiResponse(code = 1001, message = "失败"),
            @ApiResponse(code = 1002, response = User.class,message = "缺少参数") })
    public ResultVO addParams(
            @ApiParam("用户ID") @RequestParam("userId") Integer userId,
            @ApiParam("用户名") @RequestParam("name") String name,
            @ApiParam("性别") @RequestParam("sex") String sex,
            @ApiParam(value ="年龄",allowEmptyValue = true) @RequestParam(value ="age",required = false) Integer age) {

        ResultVO vo = new ResultVO();
        User user =new User();
        user.setAge(age);
        user.setUserId(userId);
        user.setName(name);
        user.setSex(sex);

        vo.setUser(user);
        vo.setCode(200);
        vo.setErrorMsg("");
        return vo;
    }

    /**
     * post请求（json）
     * @param user
     * @return
     */
    @PostMapping("/addJson")
    @ApiOperation(value = "添加用户(JSON)")
    @ApiResponses(value = {
            @ApiResponse(code = 1000, message = "成功"),
            @ApiResponse(code = 1001, message = "失败"),
            @ApiResponse(code = 1002, message = "缺少参数") })
    public ResultVO addJson(@RequestBody(required = true) User user){
        ResultVO vo = new ResultVO();

        vo.setUser(user);
        vo.setCode(200);
        vo.setErrorMsg("");
        return vo;
    }

    /**
     * put请求
     * @param user
     * @return
     */
    @PutMapping("/update")
    @ApiOperation(value = "更新用户")
    @ApiResponses(value = {
            @ApiResponse(code = 1000, message = "成功"),
            @ApiResponse(code = 1001, message = "失败"),
            @ApiResponse(code = 1002, message = "缺少参数") })
    public ResultVO update(@RequestBody(required = true) User user){
        ResultVO vo = new ResultVO();

        vo.setUser(user);
        vo.setCode(200);
        vo.setErrorMsg("");
        return vo;
    }

    /**
     * delete请求
     * @param userId
     * @return
     */
    @DeleteMapping("/delete")
    @ApiOperation(value = "删除用户")
    @ApiResponses(value = {
            @ApiResponse(code = 1000, message = "成功"),
            @ApiResponse(code = 1001, message = "失败"),
            @ApiResponse(code = 1002, message = "缺少参数") })
    public ResultVO delete( @ApiParam("用户ID") @RequestParam("userId") Integer userId){

        ResultVO vo = new ResultVO();
        User user =userService.getUser(userId);
        vo.setUser(user);
        vo.setCode(200);
        vo.setErrorMsg("");
        return vo;
    }

}