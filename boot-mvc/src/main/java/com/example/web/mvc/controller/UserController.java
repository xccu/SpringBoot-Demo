package com.example.web.mvc.controller;

import com.alibaba.fastjson.JSONArray;
import com.example.web.mvc.common.PageUtil;
import com.example.web.mvc.dto.UserDto;
import com.example.web.mvc.service.APIService;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
//@RestController
@Controller
@RequestMapping("/layui/user")
public class UserController {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss ");


    @Autowired
    APIService apiService;


    /**
     * http://localhost:8080/layui/user/?id=1
     * @param id
     * @param model
     * @return
     */
    @GetMapping(path = "/")
    public String userEdit(String id,Model model){

        List<UserDto> users= getUserList();
        UserDto user = users.stream().filter(t->t.getId().equals(id)).findFirst().orElse(null);


        model.addAttribute("user", user);

        return "application/userEdit";
    }

    /**
     * http://localhost:8080/layui/user/detail?id=1
     * @param id
     * @param model
     * @return
     */
    @GetMapping(path = "/detail")
    public String userDetail(String id,Model model) {
        List<UserDto> users= getUserList();
        UserDto user = users.stream().filter(t->t.getId().equals(id)).findFirst().orElse(null);


        model.addAttribute("user", user);

        return "application/userDetail";
    }


    @GetMapping(path = "/err")
    public String error() throws Exception {

        int a = 10/0;
        return "/";
        //throw new Exception("this is a test");
    }

    /**
     * http://localhost:8080/layui/user/idCard?id=350605250001
     * @param id
     * @param model
     * @return
     */
    @GetMapping(path = "/idCard")
    public String userIDCard(String id,Model model){

        List<UserDto> users= getUserList();
        UserDto user = users.stream().filter(t->t.getId().equals(id)).findFirst().orElse(null);


        model.addAttribute("user", user);

        return "application/idCard";
    }

    /**
     * josn格式字符串
     * url:"http://localhost:8080/layui/user/allStr"
     * @return
     */
    //@ResponseBody
    @GetMapping(value = "/allStr")
    public String getAllUserDtoStr() {
        String result =
                "{\n" +
                "    \"msg\":\"success\",\n" +
                "    \"code\":0,\n" +
                "    \"count\":15,\n" +
                "    \"data\": [\n" +
                "                {\"id\":1,\"name\":\"Weslie\",\"age\":12,\"sex\":\"male\"},\n" +
                "                {\"id\":2,\"name\":\"Wolffy\",\"age\":34,\"sex\":\"male\"},\n" +
                "                {\"id\":3,\"name\":\"Tibbie\",\"age\":11,\"sex\":\"female\"},\n" +
                "                {\"id\":4,\"name\":\"Sparky\",\"age\":12,\"sex\":\"male\"},\n" +
                "                {\"id\":5,\"name\":\"Paddi\",\"age\":10,\"sex\":\"male\"},\n" +
                "                {\"id\":6,\"name\":\"Weslie\",\"age\":12,\"sex\":\"male\"},\n" +
                "                {\"id\":7,\"name\":\"Wolffy\",\"age\":34,\"sex\":\"male\"},\n" +
                "                {\"id\":8,\"name\":\"Tibbie\",\"age\":11,\"sex\":\"female\"},\n" +
                "                {\"id\":9,\"name\":\"Sparky\",\"age\":12,\"sex\":\"male\"},\n" +
                "                {\"id\":10,\"name\":\"Paddi\",\"age\":10,\"sex\":\"male\"}\n" +
                "     ]\n" +
                "}\n";
        return result;
    }

    /**
     * json对象
     * url:"http://localhost:8080/layui/user/all"
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/all")
    public JSONObject getAllUserDtoJson(int page,int limit){

        Date d = new Date();
        log.info(sdf.format(d)+" /all:"+"page:"+page+"\tlimit:"+limit);
        List<UserDto> users= getUserList();
        int count = users.size();
        users = PageUtil.startPage(users,page,limit);
        //在传入中，为了满足Layui的格式要求，加上了一些头部：code、msg、count、data
        JSONObject json = new JSONObject();
        json.put("msg", "success");
        json.put("code", "0");
        json.put("status", "200");
        json.put("count", count);
        json.put("data", users);
        return json;
    }

    /**
     * 带参数的get请求
     * url:"http://localhost:8080/layui/user/getByName?name={name}"
     * @param name
     * @return
     */
    //@ResponseBody
    @GetMapping(value = "/getByName")
    public JSONObject getByName(String name){

        Date d = new Date();
        log.info(sdf.format(d)+" /getByName:"+name);

        List<UserDto> users= getUserList();
        users = users.stream().filter(t->t.getName().equals(name)).collect(Collectors.toList());

        //在传入中，为了满足Layui的格式要求，加上了一些头部：code、msg、count、data
        JSONObject json = new JSONObject();
        json.put("msg", "success");
        json.put("code", "0");
        json.put("status", "200");
        json.put("count", users.size());
        json.put("data", users);
        return json;
    }

    //@ResponseBody
    @GetMapping(value = "/getById")
    public JSONObject getById(String id){

        Date d = new Date();
        log.info(sdf.format(d)+" /getById:"+id);

        List<UserDto> users= getUserList();
        UserDto user = users.stream().filter(t->t.getId().equals(id)).findFirst().orElse(null);

        //在传入中，为了满足Layui的格式要求，加上了一些头部：code、msg、count、data
        JSONObject json = new JSONObject();
        json.put("msg", "success");
        json.put("code", "0");
        json.put("status", "200");
        json.put("flag", true);
        //json.put("count", users.size());
        json.put("data", user);
        return json;
    }


    private List<UserDto> getUserList(){

        String jsonString = apiService.get("user/getall");
        List<UserDto> userList = JSONArray.parseArray(jsonString, UserDto.class);


        return userList;
    }
}