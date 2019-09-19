package com.spring.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.spring.mybatisplus.mapper.UserMapper;
import com.spring.mybatisplus.model.User;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Project mybatisplus
 * @Package com.spring.mybatisplus.service
 * @Author xuzhenkui
 * @Date 2019/9/18 15:00
 */
@Service
public class UserService extends ServiceImpl<UserMapper,User> {
}