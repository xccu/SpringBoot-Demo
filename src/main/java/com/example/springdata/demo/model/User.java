package com.example.springdata.demo.model;


import lombok.Data;

import javax.persistence.*;

//使用JPA注解配置映射关系
@Entity                     //告诉JPA这是一个实体类,和数据表映射的类
@Data
@Table(name = "user")   //来指定和哪个数据表对应,如果省略,默认表名就是user
public class User {

    @Id         //标注这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //表示这个一个自增组件
    private Integer id;
    @Column                         //这是和数据表对应的一个列
    private String name;
    @Column                         //省略列名就是email即属性名
    private String password;
    @Column                         //省略列名就是email即属性名
    private Integer age;
    @Column(name = "gender")        //这是和数据表对应的一个列
    private String sex;
    @Column                         //省略列名就是race即属性名
    private String race;

    @Override
    public String toString() {
        return "User{id="+id+", name="+name+", password="+password+", age="+age+", gender="+sex+", race="+race+"}";
    }
}
