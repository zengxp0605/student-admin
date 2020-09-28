package com.stan.studentadmin.mapper;

import com.stan.studentadmin.entity.Book;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2020/9/27 12:03 下午
 * @Modified By：
 */
public interface BookMapper {

    @Select("select s.*,b.author,b.create_time" +
            " from book b left join student s on s.id=b.id")
    List<Map<String, String>> getMixedList();

    @Select("SELECT * FROM book")
    @Results({
            @Result(property = "userSex",  column = "user_sex"),
            @Result(property = "nickName", column = "nick_name")
    })
    List<Book> getAll();

    @Select("SELECT * FROM book WHERE id = #{id}")
    @Results({
            @Result(property = "userSex",  column = "user_sex"),
            @Result(property = "nickName", column = "nick_name")
    })
    Book getOne(Long id);

    @Insert("INSERT INTO book(book_name) VALUES(#{bookName})")
    void insert(Book user);

    @Update("UPDATE book SET book_name=#{bookName} WHERE id =#{id}")
    void update(Book user);

    @Delete("DELETE FROM book WHERE id =#{id}")
    void delete(Long id);
}
