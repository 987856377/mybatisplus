package com.spring.mybatisplus.module.sys.mapper;

import com.spring.mybatisplus.module.sys.entity.UserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author XuZhenkui
 * @since 2019-10-06
 */
public interface UserRoleMapper extends BaseMapper<UserRole> {
        UserRole getById(@Param("id") Integer id);
}
