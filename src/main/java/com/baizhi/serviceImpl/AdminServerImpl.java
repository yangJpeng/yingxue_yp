package com.baizhi.serviceImpl;

import com.baizhi.dao.AdminMapper;
import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
@Service
@Transactional
public class AdminServerImpl implements AdminService {
    private static final Logger log = LoggerFactory.getLogger(AdminServerImpl.class);
    @Resource
    AdminMapper adminMapper;
    @Resource
    HttpServletRequest request;

    @Override
    public HashMap <String, Object> login(Admin admin, String enCode) {
        //1.获取验证码
        String code = (String) request.getServletContext().getAttribute("code");
        log.info("用户输入的验证码：{}",enCode);
        log.info("获取存储的验证码：{}",code);
        HashMap <String, Object> map = new HashMap <>();

        //2.判断验证码是否一致
        if (code.equals(enCode)) {
            //3.判断用户是否存在
            Admin admins = adminMapper.queryByUsername(admin.getUsername());
            if (admins!=null) {
                //4.判断用户状态是否正常
                if (admins.getStatus().equals("1")) {
                    //5.判断密码是否正确
                    if (admin.getPassword().equals(admins.getPassword())) {
                        map.put("message",admins);
                        map.put("status",200);
                    } else {
                        map.put("message","密码错误");
                        map.put("status",400);
                    }
                } else {
                    map.put("message","该用户已被冻结请联系超级管理员");
                    map.put("status",400);
                }
            } else {
                map.put("message","该用户不存在");
                map.put("status",400);
            }
        } else {
            map.put("message","验证码不正确");
            map.put("status",400);
        }
        return map;
    }
}
