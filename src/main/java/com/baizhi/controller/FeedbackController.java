package com.baizhi.controller;

import com.baizhi.entity.Feedback;
import com.baizhi.service.FeedbackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
@RestController
@CrossOrigin //跨域
@RequestMapping("feedback")
public class FeedbackController {

    private static final Logger log = LoggerFactory.getLogger(FeedbackController.class);
    @Resource
    FeedbackService feedbackService;
    //接收用户反馈的信息（）
    //调用业务进行处理
    //流程跳转
    @PostMapping("queryAllPage")
    private HashMap<String,Object> queryAllPage(Integer page,Integer pageSize){
        log.info("当前页page:{}",page);
        log.info("每页展示几条数据pageSize:{}",pageSize);
        HashMap <String, Object> hashMap = feedbackService.queryAllPage(page, pageSize);

        return  hashMap;
    }
    @PostMapping("delete")
    private HashMap<String,Object>deleteFeedback(@RequestBody Feedback feedback){
        log.info("接收删除的数据{}",feedback);
        HashMap <String, Object> hashMap = feedbackService.deleteFeedback(feedback);
        return  hashMap;
    }
}
