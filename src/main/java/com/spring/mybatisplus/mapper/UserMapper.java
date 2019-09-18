package com.spring.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spring.mybatisplus.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Description
 * @Project mybatisplus
 * @Package com.spring.mybatisplus.dao
 * @Author xuzhenkui
 * @Date 2019/9/18 14:59
 */
public interface UserMapper extends BaseMapper<User> {
}
