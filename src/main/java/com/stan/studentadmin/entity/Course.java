package com.stan.studentadmin.entity;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2020/9/28 4:22 下午
 * @Modified By：
 */
@Data
@ToString
@Accessors(chain = true)
public class Course implements Serializable {
    private Integer id;
    private String cno;
    private String name;
    private Integer period;
    private Integer credit;
    private Integer pass;
}

//    INSERT INTO `course` (`id`, `cno`, `name`, `period`, `credit`, `pass`)
//        VALUES
//        (1, 'sx01', '高等数学', 20, 4, 60);
