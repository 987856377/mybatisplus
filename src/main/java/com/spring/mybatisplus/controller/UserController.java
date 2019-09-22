package com.spring.mybatisplus.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.mybatisplus.model.User;
import com.spring.mybatisplus.service.UserService;
import com.spring.mybatisplus.common.ResultCode;
import com.spring.mybatisplus.common.ResultJson;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

import static com.spring.mybatisplus.common.ResultJson.success;

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
        return success(userService.saveOrUpdate(user));
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
        return success(userService.getById((Serializable) id));
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
    @RequestMapping("deleteUserById")
    public ResultJson deleteUserById(@RequestBody Object id){
        if (id.equals(null) || id == ""){
            return ResultJson.failure(ResultCode.BAD_REQUEST);
        }
        return success(userService.removeById((Serializable) id));
    }


    /*/*
     * @Description
     * @param null
        {
            "username":"admin"
        }
     * @Return
     * @Author XuZhenkui
     * @Creed: Talk is cheap,show me the code
     * @Date 2019/9/22 1:01
     */
    @RequestMapping("getUsersByUsername")
    public ResultJson getUsersByUsername(@RequestBody User user){
        if (user == null){
            return ResultJson.failure(ResultCode.BAD_REQUEST);
        }
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(User::getUsername,user.getUsername());
        return ResultJson.success(userService.selectList(wrapper));
    }

    @RequestMapping("getByUsername")
    public ResultJson getByUsername(@RequestParam("username") String username){
        if (username == null){
            return ResultJson.failure(ResultCode.BAD_REQUEST);
        }
        return ResultJson.success(userService.getByUsername(username));
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
        return success(userService.list(null));
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
        return success(userService.page(page));
    }
}
