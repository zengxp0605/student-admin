package com.stan.studentadmin.mapper;

import com.stan.studentadmin.common.Constants;
import com.stan.studentadmin.common.RowRequest;
import com.stan.studentadmin.entity.CourseExam;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2020/9/28 4:16 下午
 * @Modified By：
 */
public interface CourseExamMapper {


    @Select("select ce.`id`, ce.`sno`, ce.`cno`, ce.`score`, ce.`exam_time` as examTime," +
            " s.name, c.name as courseName, c.pass, c.credit, " +
            " case ce.score " +
            " when ce.score < c.pass then " +
            "   c.credit " +
            " else " +
            "   0 " +
            " end as gotCredit " +
            " from `course_exam` ce " +
            " left join `student` s on s.sno=ce.sno " +
            " left join course c on c.cno=ce.cno " +
            " limit #{startNo},#{offset}")
    List<Map<String, String>> getExamPage(RowRequest rowRequest);

    @Select("select ce.`id`, ce.`sno`, ce.`cno`, ce.`score`, ce.`exam_time` as examTime," +
            "s.name, c.name as courseName, c.pass, c.credit, 0, " +
            "case ce.score " +
            " when ce.score < c.pass then " +
            "   c.credit " +
            " else " +
            "   0 " +
            " end as gotCredit " +
            "from `course_exam` ce " +
            "left join `student` s on s.sno=ce.sno " +
            "left join course c on c.cno=ce.cno " +
            "where s.name=#{studentName}")
    List<Map<String, String>> findByStudentName(String studentName);

    @Delete("delete from course_exam where id in(${ids})")
    void delete(String ids);

    @Update("update curse_exam set `sno`=#{sno}, `cno`=#{cno}, `score`=#{score}, `exam_time`=#{examTime}, where id=#{id}")
    void update();

    @Select("select `id`, `sno`, `cno`, `score`, `exam_time` as examTime from `course_exam`")
    List<CourseExam> getAll();

}
