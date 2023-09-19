package com.example.demo;

import com.example.demo.mapper.ProductMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductMapperTest {

    @Autowired
    private ProductMapper productMapper;

    //https://blog.csdn.net/qq_34337272/article/details/81072874
    @Test
    public void testOptimisticLocker() {
        System.out.println(("----- Optimistic Locker test ------"));
        //user1 get data
        Product p1 = productMapper.selectById(1L);
        //user2 get data
        Product p2 = productMapper.selectById(1L);
        //user1 + 50
        p1.setPrice(p1.getPrice() + 50);
        int result1 = productMapper.updateById(p1);
        System.out.println("User1 update result：" + result1);
        //user2 - 30
        p2.setPrice(p2.getPrice() - 30);
        int result2 = productMapper.updateById(p2);
        System.out.println("User2 update result：" + result2);
        if(result2 == 0){
            System.out.println("get version again and update");
            //失败重试，重新获取version并更新
            p2 = productMapper.selectById(1L);
            p2.setPrice(p2.getPrice() - 30);
            result2 = productMapper.updateById(p2);
        }
        System.out.println("User2 update result again：" + result2);
        //老板看价格
        Product p3 = productMapper.selectById(1L);
        System.out.println("Final result：" + p3.getPrice());
    }
}
