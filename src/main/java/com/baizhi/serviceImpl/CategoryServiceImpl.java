package com.baizhi.serviceImpl;

import com.baizhi.dao.CategoryMapper;
import com.baizhi.dto.PageDTO;
import com.baizhi.entity.Category;
import com.baizhi.entity.CategoryExample;
import com.baizhi.service.CategoryService;
import com.baizhi.util.UUIDUtil;
import com.baizhi.vo.CommonQueryPageVO;
import com.baizhi.vo.CommonVO;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.logging.Level;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Resource
    CategoryMapper categoryMapper;

    @Override
    public CommonQueryPageVO queryOnePage(PageDTO pageDTO) {
        //创建条件对象
        CategoryExample example = new CategoryExample();
        example.createCriteria().andLevelsEqualTo(1);
        //根据条件查一级类别的数量  条件  levels=1
        int total = categoryMapper.selectCountByExample(example);
        RowBounds rowBounds = new RowBounds((pageDTO.getPage() - 1) * pageDTO.getPageSize(), pageDTO.getPageSize());
        //分页查询数据
        List <Category> categoryList = categoryMapper.selectByExampleAndRowBounds(example, rowBounds);
        CommonQueryPageVO commonQueryPageVO = new CommonQueryPageVO();
        commonQueryPageVO.setPage(pageDTO.getPage());
        commonQueryPageVO.setTotal(total);
        commonQueryPageVO.setRows(categoryList);
        return commonQueryPageVO;
    }

    @Override
    public CommonVO add(Category category) {
        CategoryExample example = new CategoryExample();
        //添加的是一级类别还是二级类别
        try {
            category.setId(UUIDUtil.getUUID());
            //获取级别
            category.setLevels(1);
            //添加数据
            categoryMapper.insertSelective(category);
            return CommonVO.success("添加成功！！");
        } catch (Exception e) {
            e.printStackTrace();
            return CommonVO.faild("添加失败！！！");
        }
    }

    @Override
    public CommonVO delete(Category category) {
        if (category.getId()==null) {
            CategoryExample example = new CategoryExample();
            example.createCriteria().andParentIdEqualTo(category.getId());
            int count = categoryMapper.selectCountByExample(example);
            if (count==0) {
                categoryMapper.delete(category);
                return CommonVO.success("二级类别删除成功！！！");
            } else {
                return CommonVO.faild("该一级类别下存在二级类别不能删除");
            }
        } else {
            categoryMapper.delete(category);
            return CommonVO.success("一级类别删除成功！！");
        }
    }

    @Override
    public Category queryById(String id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public CommonVO update(Category category) {
        try {
            categoryMapper.updateByPrimaryKeySelective(category);
            return CommonVO.success("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return CommonVO.faild("修改失败！！");
        }
    }


}
