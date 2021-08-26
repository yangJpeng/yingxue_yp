package com.baizhi.controller;

import com.baizhi.dto.PageDTO;
import com.baizhi.entity.Category;
import com.baizhi.service.CategoryService;
import com.baizhi.vo.CommonQueryPageVO;
import com.baizhi.vo.CommonVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("category")
public class CategoryController {

    private static final Logger log = LoggerFactory.getLogger(CategoryController.class);
    @Resource
    CategoryService categoryService;
    @PostMapping("queryOnePage")
    public CommonQueryPageVO queryOnePage(@RequestBody PageDTO pageDTO){
        log.info("接收的数据pageDTO:{}",pageDTO);
        return categoryService.queryOnePage(pageDTO);
    }
    @PostMapping("add")
    public CommonVO add(@RequestBody Category category ){

        log.info("接收添加的数据Category:{}",category);
        return categoryService.add(category);
    }
    @RequestMapping("delete")
    public CommonVO delete(@RequestBody Category category){
        log.info("接收删除的数据Category:{}",category);
        return  categoryService.delete(category);
    }
    @GetMapping("queryById")
    public Category queryById(String id){
        log.info("接收的数据categoryId：{}",id);
        return categoryService.queryById(id);
    }

    @PostMapping("update")
    public CommonVO update(@RequestBody Category category){
        log.info("接收的数据category：{}",category);
        return categoryService.update(category);
    }


}
