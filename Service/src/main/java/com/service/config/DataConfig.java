package com.service.config;

import java.util.Properties;
import javax.annotation.Resource;
import javax.sql.DataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.AbstractEntityManagerFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.service.repository")
@EnableTransactionManagement
public class DataConfig {
    private static final String PROPERTY_DIALECT="hibernate.dialect";
    private static final String PROPERTY_SQL="hibernate.show_sql";
    private static final String PROPERTY_ENTITY="entitymanager.packages";
    
    @Resource
    private Environment env;
    
    
    @Autowired
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource datasource)
    {
        LocalContainerEntityManagerFactoryBean container=new LocalContainerEntityManagerFactoryBean();
        container.setDataSource(datasource);
        container.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        container.setPackagesToScan(env.getRequiredProperty(PROPERTY_ENTITY));
        container.setJpaProperties(getHibernateProperties());
        return container;
    }
    
    private Properties getHibernateProperties()
    {
        Properties proper=new Properties();
        proper.put(PROPERTY_DIALECT,env.getRequiredProperty(PROPERTY_DIALECT));
        proper.put(PROPERTY_SQL,env.getRequiredProperty(PROPERTY_SQL));
        return proper;
    }
    
    @Autowired
    @Bean
    public JpaTransactionManager transactionManager(AbstractEntityManagerFactoryBean entity)
    {
        JpaTransactionManager jpatransaction=new JpaTransactionManager();
        jpatransaction.setEntityManagerFactory(entity.getObject());
        return jpatransaction;
    }
}
