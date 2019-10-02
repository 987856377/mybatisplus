package com.spring.mybatisplus.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.spring.mybatisplus.mapper.UserMapper;
import com.spring.mybatisplus.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Project mybatisplus
 * @Package com.spring.mybatisplus.service
 * @Author xuzhenkui
 * @Date 2019/9/18 15:00
 */
@Service(value = "userService")
public class UserService extends ServiceImpl<UserMapper,User> {
    @Resource
    private UserMapper userMapper;

    public List<User> selectList(Wrapper wrapper){
        return userMapper.selectList(wrapper);
    }

    public List<User> getByUsername(String username){
        return userMapper.getByUsername(username);
    }

    public List<User> getUserByPage(long offset, long pageSize){
        return userMapper.getUserByPage(offset,pageSize);
    }

    public List<User> getByWrapper(Wrapper wrapper){
        return userMapper.getByWrapper(wrapper);
    }
}
