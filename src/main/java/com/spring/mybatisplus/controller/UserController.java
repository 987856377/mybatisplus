package com.spring.mybatisplus.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.mybatisplus.model.User;
import com.spring.mybatisplus.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * @Description
 * @Project mybatisplus
 * @Package com.spring.mybatisplus.controller
 * @Author xuzhenkui
 * @Date 2019/9/18 15:17
 */
@RestController
public class UserController {
    @Resource
    private UserService userService;

    /*/*
     * @Description
     * @param user
        {
            "id":"53509",
            "username":"frank",
            "password":"as",
            "age":12
        }
     * @Return java.lang.Boolean
     * @Author XuZhenkui
     * @Creed: Talk is cheap,show me the code
     * @Date 2019/9/18 18:07
     */
    @RequestMapping("saveOrUpdateUser")
    public Boolean saveOrUpdateUser(@RequestBody User user){
        return userService.saveOrUpdate(user);
    }

    /*/*
     * @Description
     * @param id
     *
        {
	        "id":1223
        }
     *
     * @Return com.spring.mybatisplus.model.User
     * @Author XuZhenkui
     * @Creed: Talk is cheap,show me the code
     * @Date 2019/9/18 18:06
     */
    @RequestMapping("getUserById")
    public User getUserById(@RequestBody Object id){
        return userService.getById((Serializable) id);
    }

    /*/*
     * @Description
     * @param id
        {
	        "id":1223
        }
     * @Return java.lang.Boolean
     * @Author XuZhenkui
     * @Creed: Talk is cheap,show me the code
     * @Date 2019/9/18 18:05
     */
    @RequestMapping("deleteUser")
    public Boolean deleteUser(@RequestBody Object id){
        return userService.removeById((Serializable) id);
    }

    /*/*
     * @Description
     * @param
     * 
     * @Return java.util.List<com.spring.mybatisplus.model.User>
     * @Author XuZhenkui
     * @Creed: Talk is cheap,show me the code
     * @Date 2019/9/18 18:05
     */
    @RequestMapping("getUserList")
    public List<User> getUserList(){
        return userService.list(null);
    }


    /*/*
     * @Description
     * @param page
        {
            "current": 1,
            "size": 5
        }
     * @Return com.baomidou.mybatisplus.core.metadata.IPage<com.spring.mybatisplus.model.User>
     * @Author XuZhenkui
     * @Creed: Talk is cheap,show me the code
     * @Date 2019/9/18 18:04
     */
    @RequestMapping("getUserPage")
    public IPage<User> getUserPage(@RequestBody Page<User> page){
        return userService.page(page);
    }
}
