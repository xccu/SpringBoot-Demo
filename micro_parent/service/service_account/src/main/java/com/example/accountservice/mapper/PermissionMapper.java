package com.example.accountservice.mapper;

import com.example.accountservice.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 权限 Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2020-01-12
 */
@Component
public interface PermissionMapper extends BaseMapper<Permission> {


    @Select("select * from acl_user_role ur" +
            "  inner join acl_role_permission rp on rp.role_id = ur.role_id" +
            "  inner join acl_permission p on p.id = rp.permission_id" +
            "  where ur.user_id = #{userId}" +
            "  and ur.is_deleted = 0" +
            "  and rp.is_deleted = 0" +
            "  and p.is_deleted = 0")
    List<String> selectPermissionValueByUserId(String userId);

    @Select("select permission_value " +
            "  from acl_permission" +
            "  where type = 2" +
            "  and is_deleted = 0")
    List<String> selectAllPermissionValue();

    @Select("select * from acl_user_role ur" +
            "  inner join acl_role_permission rp on rp.role_id = ur.role_id" +
            "  inner join acl_permission p on p.id = rp.permission_id" +
            "  where ur.user_id = #{userId}" +
            "  and ur.is_deleted = 0" +
            "  and rp.is_deleted = 0" +
            "  and p.is_deleted = 0")
    List<Permission> selectPermissionByUserId(String userId);
}
