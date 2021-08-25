package com.baizhi.serviceImpl;

import com.baizhi.dao.AdminMapper;
import com.baizhi.entity.Admin;
import com.baizhi.entity.AdminExample;
import com.baizhi.service.AdminService;
import com.baizhi.vo.CommonQueryPageVO;
import com.baizhi.vo.CommonVO;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

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



    @Override
    public CommonQueryPageVO queryAllPage(Integer Page, Integer pageSize) {
        //设置查询条件对象
        AdminExample example = new AdminExample();
        //查询总条数
        int count = adminMapper.selectCountByExample(example);
        //创建分页对象  参数：起始条数,数据数
        RowBounds rowBounds = new RowBounds((Page- 1) * pageSize, pageSize);
        //根据分页查询数据
        List <Admin> admins = adminMapper.selectByExampleAndRowBounds(example, rowBounds);
        return new CommonQueryPageVO(Page,count,admins);
    }

    @Override
    public CommonVO update(Admin admin) {
           CommonVO commonVO = new CommonVO();
        try {
            adminMapper.updateByPrimaryKeySelective(admin);
            commonVO.setMessage("修改成功!!!!");
            commonVO.setStatus(200);
        } catch (Exception e) {
            e.printStackTrace();
            commonVO.setMessage("修改失败!!!!");
            commonVO.setStatus(400);
        }

//        /* try {
//            adminMapper.updateByPrimaryKeySelective(admin);
//            return CommonVO.success();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return CommonVO.faild();
//        }*/
        return commonVO;
    }
    @Override
    public HashMap <String, Object> delete(Admin admin) {
        HashMap <String, Object> map = new HashMap <>();

        try {
            adminMapper.delete(admin);
            map.put("message","删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("message","删除失败");
        }
        return map;
    }
}
