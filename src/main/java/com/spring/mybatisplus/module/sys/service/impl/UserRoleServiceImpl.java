package com.spring.mybatisplus.module.sys.service.impl;

import com.spring.mybatisplus.module.sys.entity.UserRole;
import com.spring.mybatisplus.module.sys.mapper.UserRoleMapper;
import com.spring.mybatisplus.module.sys.service.UserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author XuZhenkui
 * @since 2019-10-06
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

    @Resource
    private UserRoleMapper userRoleMapper;
    @Override
    public UserRole getById(Integer id) {
        return userRoleMapper.getById(id);
    }
}
