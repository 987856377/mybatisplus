package com.spring.mybatisplus.aspect;

import com.spring.mybatisplus.annotation.Auth;
import com.spring.mybatisplus.common.ResultCode;
import com.spring.mybatisplus.common.ResultJson;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description
 * @Project mybatisplus
 * @Package com.spring.mybatisplus.aspect
 * @Author xuzhenkui
 * @Date 2019/10/2 9:35
 */
@Component
@Aspect
public class AuthAspect {

    private Logger logger = LoggerFactory.getLogger(AuthAspect.class);

    @Pointcut("@annotation(auth)")
    public void doAuth(Auth auth){}

    @Around("doAuth(auth)")
    public ResultJson doAround(ProceedingJoinPoint joinPoint, Auth auth) throws Throwable{
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        String[] roleList = {"USER","ADMIN","DBA"};
//        访问服务器资源需要的角色
        String[] roles = auth.roles();
//        访问者拥有的角色
        String role = request.getHeader("role");

//        访问者未携带任何角色
        if (role == null || role.equals("")){
            return ResultJson.failure(ResultCode.UNAUTHORIZED,"对不起,请登录后再试");
        }
//        验证访问者具有任何角色与服务器设定的角色是否匹配
        else if (contains(roleList,role) || contains(roles, role)){
            return ResultJson.success(joinPoint.proceed());
        }
        return ResultJson.failure(ResultCode.UNAUTHORIZED,"对不起,您没有权限访问");
    }

    public Boolean contains(String[] roles, String role){
        for (String r : roles){
            if (r.equals(role)){
                return true;
            }
        }
        return false;
    }
}
