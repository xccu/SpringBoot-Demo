package com.example.accountservice.mapper;

import com.example.accountservice.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2020-01-12
 */
@Component
public interface UserMapper extends BaseMapper<User> {

}
