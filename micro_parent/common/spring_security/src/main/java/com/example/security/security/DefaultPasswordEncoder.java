package com.example.security.security;

import com.example.utils.utils.MD5;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

//实现PasswordEncoder接口
@Component
public class DefaultPasswordEncoder implements PasswordEncoder {

    //无参构造函数
    public DefaultPasswordEncoder() {
        this(-1);
    }

    //有参构造函数
    public DefaultPasswordEncoder(int strength) {
    }

    //进行MD5加密
    @Override
    public String encode(CharSequence charSequence) {
        return MD5.encrypt(charSequence.toString());
    }

    //进行密码比对
    @Override
    public boolean matches(CharSequence charSequence, String encodedPassword) {
        return encodedPassword.equals(MD5.encrypt(charSequence.toString()));
    }
}
