package com.spring.mybatisplus.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * @Description
 * @Project mybatisplus
 * @Package com.spring.mybatisplus.model
 * @Author xuzhenkui
 * @Date 2019/9/18 14:56
 */
@TableName("user")
public class User extends Model<User> implements Serializable {
    private long id;
    private String username;
    private String password;
    private int age;

    public User(){}

    public User(long id, String username, String password, int age) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
