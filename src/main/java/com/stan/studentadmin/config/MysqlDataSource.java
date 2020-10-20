package com.stan.studentadmin.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2020/9/27 12:14 下午
 * @Modified By：
 */
public class MysqlDataSource extends DriverManagerDataSource {
    private static final Logger logger = LoggerFactory.getLogger(MysqlDataSource.class);

    private String url;
    private String username;
    private String password;

    public MysqlDataSource(String url, String username, String password) {
        super(url, username, password);
        this.url = url;
        this.username = username;
        this.password = password;
    }

    @Override
    protected Connection getConnectionFromDriver(Properties props) throws SQLException {
        logger.info("连接数据库: url={}, username={}, password={}", url, username, password);
        return DriverManager.getConnection(url, username, password);
    }
}
