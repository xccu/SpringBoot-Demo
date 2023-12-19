package com.example.security.security;

import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TokenManager {

    //token有效时长
    private long tokenEcpiration = 24*60*60*1000;

    //编码秘钥
    private String tokenSignKey = "123456";

    //1 使用jwt根据用户名生成token
    public String createToken(String username) {
        String token = Jwts.builder().setSubject(username)                              //设置token内容
                .setExpiration(new Date(System.currentTimeMillis()+tokenEcpiration))    //设置有效时长
                .signWith(SignatureAlgorithm.HS512, tokenSignKey)                       //设置密钥和编码
                .compressWith(CompressionCodecs.GZIP).compact();
        return token;
    }

    //2 根据token字符串得到用户信息
    public String getUserInfoFromToken(String token) {
        String userinfo = Jwts.parser().setSigningKey(tokenSignKey).parseClaimsJws(token).getBody().getSubject();
        return userinfo;
    }

    //3 删除token
    public void removeToken(String token) { }
}
