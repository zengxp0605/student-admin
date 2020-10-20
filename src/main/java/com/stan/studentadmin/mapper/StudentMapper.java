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
    @Select("select s.id,s.sno,s.name,s.sex,s.birthday,s.major_id as majorId,m.name as major from student s " +
            "left join major m on m.id=s.major_id " +
            "where s.sno = '${sno}' or s.name like '%${name}%'")
    List<Student> findStudent(Student student);

    @Update("update student set `sno`=#{sno}, `name`=#{name}, `sex`=#{sex}, `birthday`=#{birthday},`major_id`=#{majorId} where id=#{id}")
    boolean editStudent(Student student);

    @Select("select s.id,s.sno,s.name,s.sex,s.birthday,s.major_id as majorId,m.name as major from student s " +
            "left join major m on m.id=s.major_id")
    List<Student> getAll();
}
