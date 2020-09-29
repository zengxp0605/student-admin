package com.stan.studentadmin.mapper;

import com.stan.studentadmin.common.RowRequest;
import com.stan.studentadmin.entity.CourseExam;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
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

    /**
     * 获取总数量
     *
     * @return
     */
    @Select("select count(*) " +
            " from `course_exam` ce " +
            " left join `student` s on s.sno=ce.sno " +
            " left join course c on c.cno=ce.cno")
    int getExamTotal();

    /**
     * 分页获取考试成绩
     *
     * @param rowRequest
     * @return
     */
    @Select("select ce.`id`, ce.`sno`, ce.`cno`, ce.`score`, ce.`exam_time` as examTime," +
            " s.name, c.name as courseName, c.pass, c.credit, " +
            " case " +
            " when ce.score >= c.pass then " +
            "   c.credit " +
            " else " +
            "   0 " +
            " end as gotCredit " +
            " from `course_exam` ce " +
            " left join `student` s on s.sno=ce.sno " +
            " left join course c on c.cno=ce.cno " +
            " order by ce.id desc" +
            " limit #{startNo},#{offset}")
    List<Map<String, String>> getExamPage(RowRequest rowRequest);

    /**
     * 按学生姓名查找考试成绩
     *
     * @param studentName
     * @return
     */
    @Select("select ce.`id`, ce.`sno`, ce.`cno`, ce.`score`, ce.`exam_time` as examTime," +
            "s.name, c.name as courseName, c.pass, c.credit, 0, " +
            " case " +
            " when ce.score >= c.pass then " +
            "   c.credit " +
            " else " +
            "   0 " +
            " end as gotCredit " +
            " from `course_exam` ce " +
            " left join `student` s on s.sno=ce.sno " +
            " left join course c on c.cno=ce.cno " +
            " where s.name=#{studentName}")
    List<Map<String, String>> findByStudentName(String studentName);

    /**
     * 按区间统计成绩数据
     *
     * @param cno
     * @return
     */
    @Select("select elt(" +
            " interval(score,0,60,70,80,90),'1/0-59','2/60-69','3/70-79','3/80-89','4/90-100') " +
            " as scoreLevel, count(*) as count " +
            " from course_exam where cno = #{cno} " +
            " group by cno, scoreLevel " +
            " order by cno, scoreLevel")
    List<Map<String, String>> getCourseStatistics(String cno);

    @Delete("delete from course_exam where id = #{id}")
    boolean delete(int id);

    @Update("update course_exam set `score`=#{score} where id=#{id}")
    int update();

    @Insert("insert into course_exam set `score`=#{score},sno=#{sno},cno=#{cno},exam_time=#{examTime}")
    int insert(CourseExam courseExam);

    @Select("select `id`, `sno`, `cno`, `score`, `exam_time` as examTime from `course_exam`")
    List<CourseExam> getAll();

}
