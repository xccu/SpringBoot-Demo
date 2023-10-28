package com.xccu.web.api.bootapi.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("t_user")
public class User {
    @TableId()
    private String id;
    private String name;
    private String password;
    private Integer age;
    private String gender;
    private String race;
    @TableField("img_url")
    private String imgUrl;
    private String email;
    @TableField("phone_number")
    private String phoneNo;
    @TableField("birth_date")
    private Date birthDate;
    @TableField("issue_date")
    private Date issueDate;
}
