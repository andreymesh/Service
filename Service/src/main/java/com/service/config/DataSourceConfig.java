package com.service.config;

import javax.annotation.Resource;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:app.properties")
public class DataSourceConfig {
    private static final String PROPERTY_DB_DRIVER="db.driver";
    private static final String PROPERTY_URL="db.url";
    private static final String PROPERTY_USERNAME="db.username";
    private static final String PROPERTY_PASSWORD="db.password";
    
    @Resource
    private Environment env;
    
    @Bean
    public DataSource dataSource()
    {
        DriverManagerDataSource datasource=new DriverManagerDataSource();
        datasource.setDriverClassName(env.getRequiredProperty(PROPERTY_DB_DRIVER));
        datasource.setUrl(env.getRequiredProperty(PROPERTY_URL));
        datasource.setUsername(env.getRequiredProperty(PROPERTY_USERNAME));
        datasource.setPassword(env.getRequiredProperty(PROPERTY_PASSWORD));
        return datasource;
    }
}
