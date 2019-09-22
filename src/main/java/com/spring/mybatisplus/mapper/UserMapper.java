package com.spring.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.spring.mybatisplus.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description
 * @Project mybatisplus
 * @Package com.spring.mybatisplus.dao
 * @Author xuzhenkui
 * @Date 2019/9/18 14:59
 */
public interface UserMapper extends BaseMapper<User> {

//    自定义SQL查询: 1.注解方式 2.xml方式
//    @Select("select * from user where username = #{username}")
    public List<User> getByUsername(@Param("username") String username);

//    @Select("select * from user limit #{offset}, #{pageSize}")
    public List<User> getUserByPage(@Param("offset") int offset, @Param("pageSize") int pageSize);

//    自定义SQL查询: 使用Wrapper
    public List<User> getByWrapper(@Param(Constants.WRAPPER)Wrapper wrapper);
}

