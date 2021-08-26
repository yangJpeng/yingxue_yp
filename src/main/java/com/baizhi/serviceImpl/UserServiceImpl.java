package com.baizhi.serviceImpl;

import com.baizhi.dao.UserMapper;
import com.baizhi.entity.*;
import com.baizhi.service.UserService;
import com.baizhi.vo.CommonQueryPageVO;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;
    @Override
    public HashMap <String, Object> QueryAllPage(Integer page, Integer pageSize) {
        HashMap <String,Object> map = new HashMap <>();
        //设置当前页
        map.put("page:",page);
        //设置查询条件对象
        FeedbackExample example = new FeedbackExample();
        //查询总条数
        int count = userMapper.selectCountByExample(example);
        //设置总条数
        map.put("total",count);
        //创建分页对象  参数：起始条数,数据数
        RowBounds rowBounds = new RowBounds((page - 1) * pageSize, pageSize);
        //根据分页查询数据
        List <User> users = userMapper.selectByExampleAndRowBounds(example, rowBounds);
        //设置数据
        map.put("rows",users);
        return map;
    }

    @Override
    public HashMap <String, Object> update(User user) {
        HashMap <String,Object> map = new HashMap <>();
        try {
            userMapper.updateByPrimaryKeySelective(user);
            map.put("message","修改成功!!!!");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("message","修改失败!!!!");
        }
        return map;
    }

    @Override
    public HashMap <String, Object> delete(User user) {
        HashMap <String, Object> hashMap = new HashMap <>();
        try {
            userMapper.delete(user);
            hashMap.put("message","删除成功！！");
        } catch (Exception e) {
            e.printStackTrace();
            hashMap.put("message","删除失败!!");
        }
        return hashMap;
    }


}
