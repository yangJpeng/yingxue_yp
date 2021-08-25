package com.baizhi;

import com.baizhi.dao.AdminMapper;
import com.baizhi.dao.FeedbackMapper;
import com.baizhi.entity.Admin;
import com.baizhi.entity.Feedback;
import com.baizhi.entity.FeedbackExample;
import org.apache.ibatis.session.RowBounds;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class YingxueYpApplicationTests {
    private static final Logger log = LoggerFactory.getLogger(YingxueYpApplicationTests.class);
    @Resource
    AdminMapper adminMapper;
    FeedbackMapper feedbackMapper;
    @Test
    void contextLoads() {
        Admin admin = adminMapper.queryByUsername("1");
        log.info("admin:",admin);
    }

    @Test
    void other() {

        boolean b = feedbackMapper.existsWithPrimaryKey("2");

        System.out.println(b);
    }

    @Test
    void query() {

        Feedback feedback = new Feedback();
        feedback.setId("1");
        feedback.setUserId("11");

        //List<Feedback> feedbacks = feedbackMapper.selectAll();//查询所有
        //Feedback feedback1 = feedbackMapper.selectByPrimaryKey("1");//根据id查询
        //List<Feedback> select = feedbackMapper.select(feedback);//根据对象数据查询


        //创建分页对象  参数：起始条数，获取的数据条数
        RowBounds rowBounds = new RowBounds(0, 2);

        //创建条件对象
        FeedbackExample example = new FeedbackExample();
        //example.createCriteria().andUserIdEqualTo("12");

        example.createCriteria().andContentEqualTo("xxxxxxx");

        //分页查询
        //List<Feedback> feedbacks = feedbackMapper.selectByRowBounds(new Feedback(),rowBounds );
        List <Feedback> feedbacks = feedbackMapper.selectByExampleAndRowBounds(example, rowBounds);

        for (Feedback feedback1 : feedbacks) {
            System.out.println(feedback1);
        }


    }

    @Test
    void queryById() {

        Feedback feedback = feedbackMapper.queryById("2");

        System.out.println(feedback);


    }

}
