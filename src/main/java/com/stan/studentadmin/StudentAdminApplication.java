package com.stan.studentadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.stan.studentadmin.mapper")
public class StudentAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentAdminApplication.class, args);
    }

}
