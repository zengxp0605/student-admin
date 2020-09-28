package com.stan.studentadmin.entity;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2020/9/28 4:20 下午
 * @Modified By：
 */
@Data
@ToString
@Accessors(chain = true)
public class Student implements Serializable {
    private Integer id;
    private String sno;
    private String name;
    private Integer sex;
    private Date birthday;
    private String major;
}

//    INSERT INTO `student` (`id`, `sno`, `name`, `sex`, `birthday`, `major`)
//        VALUES
//        (1, 's10000', '邬佳毅', 1, '2005-06-04', '计算机信息管理');
