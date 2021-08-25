package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import com.baizhi.util.ImageCodeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;

@CrossOrigin //处理跨越
@RestController
@RequestMapping("admin")
public class AdminController {

    private static final Logger log = LoggerFactory.getLogger(AdminController.class);
    @Resource
    AdminService adminService;

    @RequestMapping("getImageCodes")
    public String getImageCodes(HttpServletRequest request) {
        //1.获取验证码随机字符
        String code = ImageCodeUtil.getSecurityCode();
        log.info("验证码为：{}",code);
        //2.存储验证码随机字符
        request.getServletContext().setAttribute("code", code);
        //3.生成验证码图片将验证码图片转为Base64格式
        String ImgBase64=null;
        try {
            ImgBase64 = ImageCodeUtil.careateImgBase64(code);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ImgBase64;
    }
    @PostMapping("login")
    public HashMap <String, Object> login(@RequestBody Admin admin, String enCode) {
        log.info("接收用户输入的admin:{}",admin);
        log.info("接收用户输入的验证码:{}",enCode);
        HashMap <String, Object> map = adminService.login(admin, enCode);
        return map;
    }
    @PostMapping("logRemove")
    public void logRemove(HttpServletRequest request){
        log.info("退出登录");
        //移除用户登录标记
        request.getServletContext().removeAttribute("admin");
    }


}
