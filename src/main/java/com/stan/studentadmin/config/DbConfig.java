package com.stan.studentadmin.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2020/9/27 11:23 上午
 * @Modified By：
 */
@Configuration
public class DbConfig {

    @Value("${db.url}")
    private String dbUrl;

    @Value("${db.username}")
    private String dbUserName;

    @Value("${db.password}")
    private String dbPassword;

    /**
     * Configures the data source.
     *
     * @return DataSource.
     */
    @Bean
    public DataSource dataSource() {

        final DataSource dataSource = new MysqlDataSource(dbUrl, dbUserName, dbPassword);

        return dataSource;
    }

    /**
     * Spring JDBC Template
     *
     * @return JdbcTemplate
     */
    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }
}
