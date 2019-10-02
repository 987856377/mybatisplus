package com.spring.mybatisplus.annotation;

import java.lang.annotation.*;

/**
 * @Description
 * @Project mybatisplus
 * @Package com.spring.mybatisplus.annotation
 * @Author xuzhenkui
 * @Date 2019/10/2 9:30
 */
@Documented
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Auth {
    String[] roles() default "";
}
