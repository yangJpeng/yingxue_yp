package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Table(name = "yx_feedback")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {
    @Id //该属性是主键
    private String id;

    private String title;

    private String content;
    //配置属性名与数据库字段对应
    @Column(name = "user_id")
    private String userId;
    @Column(name = "create_time")
    private Date createTime;

}