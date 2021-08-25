package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.HashMap;
@CrossOrigin
@RestController
@RequestMapping("user")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Resource
    UserService userService;
    //分页查询
    @RequestMapping("queryAllPage")
    public HashMap<String,Object>queryAllPage(Integer page,Integer pageSize){
        log.info("当前页page:{}",page);
        log.info("每页展示几条数据pageSize:{}",pageSize);
        HashMap <String, Object> map = userService.QueryAllPage(page, pageSize);
        return  map;
    }
    //修改状态
    @RequestMapping("update")
    public HashMap<String,Object>update(@RequestBody User user){
        log.info("修改用户数据：{}",user);
        HashMap <String, Object> hashMap = userService.update(user);
        return hashMap;
    }
    //删除
    @RequestMapping("delete")
    public HashMap<String,Object>delete(@RequestBody User user){
        log.info("删除用户数据:{}",user);
        HashMap <String, Object> map = userService.delete(user);
        return map;
    }

}
