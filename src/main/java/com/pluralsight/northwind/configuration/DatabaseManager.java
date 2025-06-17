package com.pluralsight.northwind.configuration;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseManager {

    @Bean
    public DataSource getDataSource() {
        String username = "root";
        String password = "yearup";
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/northwind");
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
