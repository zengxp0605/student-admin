package com.stan.studentadmin.mapper;

import com.stan.studentadmin.entity.Student;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2020/9/28 4:25 下午
 * @Modified By：
 */
public interface StudentMapper {

    @Select("select * from student where sno = '${sno}' or name like '%${name}%'")
    List<Student> findStudent(Student student);

    @Update("update student set `sno`=#{sno}, `name`=#{name}, `sex`=#{sex}, `birthday`=#{birthday}, `major`=#{major} where id=#{id}")
    boolean editStudent(Student student);

    @Select("select * from student")
    List<Student> getAll();
}
