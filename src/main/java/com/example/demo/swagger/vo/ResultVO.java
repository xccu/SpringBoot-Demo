package com.example.demo.swagger.vo;

import com.example.demo.swagger.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class ResultVO {
    User user;
    int code;
    String errorMsg;
}
