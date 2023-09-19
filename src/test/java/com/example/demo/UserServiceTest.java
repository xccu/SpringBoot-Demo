package com.example.demo;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.Services.UserService;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.model.enums.GenderEnum;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class UserServiceTest {

    //https://blog.csdn.net/weixin_46751741/article/details/129043556

    
    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSave() {

        System.out.println(("----- Save method test ------"));

        User user = new User();
        user.setId(10);
        user.setAge(12);
        user.setSex(GenderEnum.MALE);
        user.setName("test");

        boolean result = userService.save(user);
        Assert.assertTrue(result);
    }

    @Test
    public void testSaveBatch() {

        System.out.println(("----- SaveBatch method test ------"));

        List<User> users= new ArrayList<User>();

        User user1 = new User();
        user1.setId(11);
        user1.setAge(12);
        user1.setSex(GenderEnum.MALE);
        user1.setName("test");
        users.add(user1);

        User user2 = new User();
        user2.setId(12);
        user2.setAge(12);
        user2.setSex(GenderEnum.MALE);
        user2.setName("test");
        users.add(user2);

        boolean result = userService.saveBatch(users);
        Assert.assertTrue(result);
    }

    @Test
    public void testList(){
        System.out.println(("----- List method test ------"));

        List<User> users1 = userService.list();
        Assert.assertEquals(users1.size(),5);

        QueryWrapper wrapper=new QueryWrapper();
        wrapper.in("id",1,2,3);
        List<User> users2 = userService.list(wrapper);
        Assert.assertEquals(users2.size(),3);

        List<Map<String, Object>> maps = userService.listMaps();
        Assert.assertEquals(maps.size(),5);
    }

    @Test
    public void testPage(){
        System.out.println(("----- Page method test ------"));

        Page<User> userPage = new Page(2, 2);
        // 无条件分页查询
        List<User> users1 = userService.page(userPage).getRecords();
        for(User user : users1) {
            System.out.println(user);
        }

        // 条件分页查询
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.in("id",1,2,3);
        List<User> users2 = userService.page(userPage,wrapper).getRecords();
        for(User user : users2) {
            System.out.println(user);
        }
    }


}
