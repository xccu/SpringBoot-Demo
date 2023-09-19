package com.example.demo;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.UpdateChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.model.enums.GenderEnum;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class UserMapperTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSqlQuery() {

        System.out.println(("----- Sql Query test ------"));

        System.out.println(("----- Caprinae ------"));
        List<User> users = userMapper.queryByRace("Caprinae");
        users.forEach(System.out::println);

        System.out.println(("----- Lupo ------"));
        users = userMapper.queryByRace("Lupo");
        users.forEach(System.out::println);
    }

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> users = userMapper.selectList(null);
        Assert.assertEquals(9, users.size());
        users.forEach(System.out::println);

        System.out.println(("----- QueryWrapper test ------"));
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.in("id",1,2,3);
        users = userMapper.selectList(wrapper);
        Assert.assertEquals(3, users.size());
        users.forEach(System.out::println);

        System.out.println(("----- QueryWrapper greater test ------"));
        wrapper = new QueryWrapper();
        wrapper.ge("age",30);
        users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    @Test
    void testInsert() {
        User user = new User();
        user.setAge(12);
        user.setSex(GenderEnum.MALE);
        user.setName("test");

        userMapper.insert(user);
        Assert.assertNotNull(user.getId());
    }

    @Test
    void testUpdate(){
        User user = new User();
        user.setAge(12);
        user.setSex(GenderEnum.MALE);
        user.setName("test");

        QueryWrapper wrapper=new QueryWrapper();
        wrapper.in("id",1,2,3);

        userMapper.update(user,wrapper);

        user.setId(4);
        //在调用updateById方法前，需要在T entity（对应的实体类）中的主键属性上加上@TableId注解。
        userMapper.updateById(user);
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    void testDelete(){
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.in("id",1,2);
        userMapper.delete(wrapper);


        List<Integer> ids =  new ArrayList<Integer>(Arrays.asList(3,4,5));
        userMapper.deleteBatchIds(ids);

        int count = userMapper.selectCount(null);

        Assert.assertEquals(count,0);
    }

    //https://blog.csdn.net/qq_43203949/article/details/120969281
    @Test
    public void testChain(){
        //链式查询 普通
        User user1 = new QueryChainWrapper<>(userMapper).eq("name", "Weslie").one();
        System.out.println(user1);
        // 链式查询 lambda 式。注意：不支持 Kotlin
        User user2 = new LambdaQueryChainWrapper<>(userMapper).eq(User::getName, "Wolffy").one();
        System.out.println(user2);


        User userUpdate = new User();
        userUpdate.setAge(12);
        userUpdate.setSex(GenderEnum.MALE);
        userUpdate.setName("test");

        // 链式更改 普通
        new UpdateChainWrapper<>(userMapper).eq("name", "Weslie").remove();
        // 链式更改 lambda 式。注意：不支持 Kotlin
        new LambdaUpdateChainWrapper<>(userMapper).eq(User::getName, "Wolffy").update(userUpdate);

    }

    @Test
    public void testCondition(){

        System.out.println(("----- Condition test ------"));

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        int ageBegin = 30;
        int ageEnd = 40;
        String userName = "";
        wrapper.like(StringUtils.isNotBlank(userName), "username", "a")
                .ge(ageBegin != 0, "age", ageBegin)
                .le(ageEnd != 0, "age", ageEnd);

        List<User> users = userMapper.selectList(wrapper);
        Assert.assertEquals(2, users.size());
        users.forEach(System.out::println);
    }

    @Test
    public void testLambdaQueryWrapper(){
        System.out.println(("----- Lambda QueryWrapper test ------"));

        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        int ageBegin = 30;
        int ageEnd = 40;
        String userName = "";
        wrapper.like(StringUtils.isNotBlank(userName), User::getName, "a")
                .ge(ageBegin != 0, User::getAge, ageBegin)
                .le(ageEnd != 0, User::getAge, ageEnd);

        List<User> users = userMapper.selectList(wrapper);
        Assert.assertEquals(2, users.size());
        users.forEach(System.out::println);
    }

    @Test
    public void testLambdaUpdateWrapper(){
        System.out.println(("----- Lambda QueryWrapper test ------"));

        LambdaUpdateWrapper<User> wrapper = new LambdaUpdateWrapper<>();
        int ageBegin = 30;
        int ageEnd = 40;
        String userName = "";
        wrapper.set(User::getAge, 18)
                .eq(User::getRace, "Lupo")
                .and(i -> i.le(User::getAge, 30).or().eq(User::getSex,"male")); //lambda
        //表达式内的逻辑优先运算

        User user = new User();
        int result  = userMapper.update(user,wrapper);
    }

    @Test
    public void testPage(){
        //设置分页参数
        Page<User> page = new Page<>(2, 3);
        userMapper.selectPage(page, null);

        //获取分页数据
        List<User> list = page.getRecords();
        list.forEach(System.out::println);
        System.out.println("current page："+page.getCurrent());
        System.out.println("page size："+page.getSize());
        System.out.println("total count："+page.getTotal());
        System.out.println("total page："+page.getPages());
        System.out.println("has previoud："+page.hasPrevious());
        System.out.println("has next："+page.hasNext());
    }

    @Test
    public void testGenderEnum(){
        User user = new User();
        user.setName("Enum");
        user.setAge(20);
        //设置性别信息为枚举项，会将@EnumValue注解所标识的属性值存储到数据库
        user.setSex(GenderEnum.MALE);
        //INSERT INTO t_user ( username, age, sex ) VALUES ( ?, ?, ? )
        //Parameters: Enum(String), 20(Integer), 1(Integer)

        int result = userMapper.insert(user);
        Assert.assertEquals(1, result);
    }

}
