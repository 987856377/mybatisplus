package com.spring.mybatisplus.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.mybatisplus.model.User;
import com.spring.mybatisplus.service.UserService;
import com.spring.mybatisplus.common.ResultCode;
import com.spring.mybatisplus.common.ResultJson;
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
    public ResultJson saveOrUpdateUser(@RequestBody User user){
        if (user==null){
            return ResultJson.failure(ResultCode.NOT_ACCEPTABLE);
        }
        return ResultJson.success(userService.saveOrUpdate(user));
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
    public ResultJson<User> getUserById(@RequestBody Object id){
        if (id.equals(null) || id == ""){
            return ResultJson.failure(ResultCode.BAD_REQUEST);
        }
        return ResultJson.success(userService.getById((Serializable) id));
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
    public ResultJson deleteUser(@RequestBody Object id){
        if (id.equals(null) || id == ""){
            return ResultJson.failure(ResultCode.BAD_REQUEST);
        }
        return ResultJson.success(userService.removeById((Serializable) id));
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
    public ResultJson<List<User>> getUserList(){
        return ResultJson.success(userService.list(null));
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
    public ResultJson<IPage<User>> getUserPage(@RequestBody Page<User> page){
        return ResultJson.success(userService.page(page));
    }
}
