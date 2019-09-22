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
     * @Description 提交 json 格式的参数.
     * 不传id参数为新建,id自增; 传id参数为新建或修改, id数据不存在,则新建,反之则修改
     * @param user
     *
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
        if (user.getId() == null){
            return ResultJson.success(userService.save(user));
        }
        return ResultJson.success(userService.saveOrUpdate(user));
    }

    /*/*
     * @Description 提交 json 格式的参数
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
    public ResultJson getUserById(@RequestBody Object id){
        if (id == null){
            return ResultJson.failure(ResultCode.BAD_REQUEST);
        }
        return ResultJson.success(userService.getById((Serializable) id));
    }

    /*/*
     * @Description 提交 json 格式的参数
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
        if (id == null){
            return ResultJson.failure(ResultCode.BAD_REQUEST);
        }
        return ResultJson.success(userService.removeById((Serializable) id));
    }


    /*/*
     * @Description 提交 json 格式的参数
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

    /*/*
     * @Description 提交 json 格式的参数
     * @param null
        {
            "username":"admin"
        }
     * @Return
     * @Author XuZhenkui
     * @Creed: Talk is cheap,show me the code
     * @Date 2019/9/22 1:01
     */
    @RequestMapping("getByUsername")
    public ResultJson getByUsername(@RequestBody User user){
        if (user == null){
            return ResultJson.failure(ResultCode.BAD_REQUEST);
        }
        return ResultJson.success(userService.getByUsername(user.getUsername()));
    }

    /*/*
     * @Description 提交 json 格式的参数
     * @param null
        {
            "username":"admin"
        }
     * @Return
     * @Author XuZhenkui
     * @Creed: Talk is cheap,show me the code
     * @Date 2019/9/22 1:01
     */
    @RequestMapping("getByWrapper")
    public ResultJson getByWrapper(@RequestBody User user){
        if (user == null){
            return ResultJson.failure(ResultCode.BAD_REQUEST);
        }
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(User::getUsername,user.getUsername());
        return ResultJson.success(userService.getByWrapper(wrapper));
    }

    /*/*
     * @Description 提交 json 格式的参数
     * @param
     *
     * @Return java.util.List<com.spring.mybatisplus.model.User>
     * @Author XuZhenkui
     * @Creed: Talk is cheap,show me the code
     * @Date 2019/9/18 18:05
     */

    @RequestMapping("getUserList")
    public ResultJson getUserList(){
        return ResultJson.success(userService.list(null));
    }

    /*/*
     * @Description 提交 form 表单格式的参数
     * @param pageNum
     * @param pageSize
        {
            "pageNum": 1,
            "pageSize": 5
        }
     * @Return com.spring.mybatisplus.common.ResultJson
     * @Author XuZhenkui
     * @Creed: Talk is cheap,show me the code
     * @Date 2019/9/22 23:26
     */
    @RequestMapping("getUserByPage")
    public ResultJson getUserByPage(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
        if (pageNum <= 0 || pageSize <= 0){
            pageNum = 1;
            pageSize = 10;
        }
        int offset = (pageNum-1)*pageSize;
        return ResultJson.success(userService.getUserByPage(offset,pageSize));
    }

    /*/*
     * @Description 提交 json 格式的参数
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
