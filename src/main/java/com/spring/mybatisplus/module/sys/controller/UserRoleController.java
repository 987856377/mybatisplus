package com.spring.mybatisplus.module.sys.controller;


import com.spring.mybatisplus.module.sys.entity.UserRole;
import com.spring.mybatisplus.module.sys.service.UserRoleService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author XuZhenkui
 * @since 2019-10-06
 */
@RestController
@RequestMapping("/sys/user-role")
public class UserRoleController {
    @Resource
    private UserRoleService userRoleService;

    @RequestMapping("getById")
    public UserRole getById(@RequestBody UserRole userRole){
        return userRoleService.getById(userRole.getId());
    }
}
