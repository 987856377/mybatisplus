package com.spring.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spring.mybatisplus.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description
 * @Project mybatisplus
 * @Package com.spring.mybatisplus.dao
 * @Author xuzhenkui
 * @Date 2019/9/18 14:59
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
//    @Select("select * from user where username = #{username}")
    public List<User> getByUsername(@Param("username") String username);
}

