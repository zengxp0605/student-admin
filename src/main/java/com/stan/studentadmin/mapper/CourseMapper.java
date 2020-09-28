package com.stan.studentadmin.mapper;

import com.stan.studentadmin.entity.Course;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2020/9/28 4:23 下午
 * @Modified By：
 */
public interface CourseMapper {

    @Select("select * from course")
    List<Course> getAll();
}
