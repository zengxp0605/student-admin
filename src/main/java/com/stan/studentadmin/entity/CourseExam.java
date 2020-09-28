package com.stan.studentadmin.entity;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2020/9/28 4:18 下午
 * @Modified By：
 */
@Data
@ToString
@Accessors(chain = true)
public class CourseExam implements Serializable {
    private Integer id;
    private String sno;
    private String cno;
    private Integer score;
    private Date examTime;
}
