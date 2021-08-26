package com.baizhi.service;

import com.baizhi.entity.Admin;
import com.baizhi.vo.CommonQueryPageVO;
import com.baizhi.vo.CommonVO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;

public interface AdminService {
    HashMap <String,Object> login(Admin admin, String enCode);
    HashMap <String,Object> delete(@RequestBody Admin admin);

    CommonQueryPageVO queryAllPage(Integer Page,Integer pageSize);
    CommonVO update(Admin admin);
    CommonVO add(Admin admin);

    Admin queryById(String id);
}
