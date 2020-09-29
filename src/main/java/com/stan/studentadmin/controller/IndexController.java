package com.stan.studentadmin.controller;

import com.stan.studentadmin.common.RowRequest;
import com.stan.studentadmin.entity.Book;
import com.stan.studentadmin.entity.CourseExam;
import com.stan.studentadmin.entity.Student;
import com.stan.studentadmin.mapper.CourseExamMapper;
import com.stan.studentadmin.mapper.CourseMapper;
import com.stan.studentadmin.mapper.StudentMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2020/9/27 11:24 上午
 * @Modified By：
 */
@CrossOrigin("*")
@RestController()
@RequestMapping("/api")
public class IndexController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private CourseExamMapper courseExamMapper;

    @Autowired
    private StudentMapper studentMapper;

    @RequestMapping("/getAllCourse")
    public Object getAllCourse() {
        return courseMapper.getAll();
    }

    @RequestMapping("/getAllStudent")
    public Object getAllStudent() {
        return studentMapper.getAll();
    }

    @RequestMapping("/getExamPage")
    public Object getExamPage(
            @RequestParam(name = "pageNo", defaultValue = "1") int pageNo,
            @RequestParam(name = "pageSize", defaultValue = "20") int pageSize,
            @RequestParam(name = "name", defaultValue = "") String name
    ) {
        logger.info("getExamPage参数: {}, {}, name={}", pageNo, pageSize, name);

        List rows;
        int total = 0;
        if (!StringUtils.isEmpty(name)) {
            rows = courseExamMapper.findByStudentName(name);
        } else {
            rows = courseExamMapper.getExamPage(new RowRequest(pageNo, pageSize));
            total = courseExamMapper.getExamTotal();
        }

        final int t = total;
        return new HashMap<String, Object>() {{
            put("rows", rows);
            put("total", t);
        }};
    }

    @RequestMapping("/findStudent")
    public Object findStudent(
            @RequestParam(name = "sno", defaultValue = "") String sno,
            @RequestParam(name = "name", defaultValue = "") String name
    ) {
        Student student = new Student();
        student.setName(StringUtils.isEmpty(name) ? "null" : name)
                .setSno(sno);
        System.out.println(student);
        return studentMapper.findStudent(student);
    }

    @RequestMapping("/editStudent")
    public Object editStudent(
            @RequestBody Student student
    ) {
        logger.info("编辑学生信息：{}", student);
        return studentMapper.editStudent(student);
    }

    @RequestMapping("/getCourseStatistics")
    public Object getCourseStatistics(
            @RequestParam String cno
    ) {
        return courseExamMapper.getCourseStatistics(cno);
    }

    @RequestMapping("/insertCourseExam")
    public Object insertCourseExam(
            @RequestBody CourseExam courseExam
    ) {
        try {
            int res = courseExamMapper.insert(courseExam);
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping("/deleteCourseExam")
    public Object deleteCourseExam(
            @RequestParam Integer id
    ) {
        return courseExamMapper.delete(id);
    }

    /**
     * Test jdbc
     *
     * @return
     */
    @RequestMapping("/jdbc")
    public Object jdbc() {
        List<Book> bookList = jdbcTemplate.query("select * from book", (resultSet, i) -> {
            String author = resultSet.getString("author");
            int id = resultSet.getInt("id");
            Book book = new Book();
            book.setAuthor(author);
            book.setId(id);
            return book;
        });

        logger.info("bookList: {}", bookList);
        return bookList;
    }
}
