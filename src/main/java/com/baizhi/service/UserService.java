package com.baizhi.service;

import com.baizhi.entity.User;

import java.util.HashMap;

public interface UserService {
    HashMap<String,Object> QueryAllPage(Integer page,Integer pageSize);
    HashMap<String,Object>update(User user);
    HashMap<String,Object>delete(User user);
}
