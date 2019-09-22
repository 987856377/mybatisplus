package com.spring.mybatisplus.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.spring.mybatisplus.mapper.UserMapper;
import com.spring.mybatisplus.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Project mybatisplus
 * @Package com.spring.mybatisplus.service
 * @Author xuzhenkui
 * @Date 2019/9/18 15:00
 */
@Service
@Transactional
public class UserService extends ServiceImpl<UserMapper,User> {
    @Resource
    private UserMapper userMapper;

    public List<User> getByUsername(String username){
        return userMapper.getByUsername(username);
    }

    public List<User> selectList(Wrapper wrapper){
        return userMapper.selectList(wrapper);
    }
}
