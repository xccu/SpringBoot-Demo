package com.example.security.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("user")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @TableId
    private Integer id;
    private String name;
    private String password;
    private Integer age;
    private String gender;
    private String race;
}