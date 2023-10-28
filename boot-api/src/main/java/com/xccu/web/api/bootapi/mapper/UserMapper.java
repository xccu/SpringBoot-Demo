package com.xccu.web.api.bootapi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xccu.web.api.bootapi.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user where race = #{race}")
    List<User> queryByRace(String race);

}