package com.spring.mybatisplus.module.sys.service;

import com.spring.mybatisplus.module.sys.entity.UserRole;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author XuZhenkui
 * @since 2019-10-06
 */
public interface UserRoleService extends IService<UserRole> {
    UserRole getById(Integer id);
}
