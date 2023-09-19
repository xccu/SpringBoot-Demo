package com.example.springdata.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "audit_user")
public class AuditUser {

    /*@CreatedBy
    private User user;*/

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
    @CreatedDate		//创建时间
    @Column
    private Date createTime;

    @LastModifiedDate        //最后更新时间
    @Column
    private Date updateTime;

}
