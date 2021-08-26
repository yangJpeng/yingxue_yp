package com.baizhi.service;

import com.baizhi.dto.PageDTO;
import com.baizhi.entity.Category;
import com.baizhi.vo.CommonQueryPageVO;
import com.baizhi.vo.CommonVO;
import org.springframework.web.bind.annotation.RequestBody;

public interface CategoryService {

    CommonQueryPageVO queryOnePage(PageDTO pageDTO);
    CommonVO add(@RequestBody Category category);
    CommonVO delete(@RequestBody Category category);
    Category queryById(String id);
    CommonVO update(Category category);

}
