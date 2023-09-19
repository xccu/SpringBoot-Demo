package com.example.springdata.demo.config;

import com.example.springdata.demo.audit.MyAuditorAware;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;


//https://blog.csdn.net/taojin12/article/details/88573580
@Configuration
@EnableJpaAuditing
public class ApplicationConfig  {


    /**
     * 自定义数据源
     * @return
     */
    @Bean(name = "datasource")
    @ConfigurationProperties(prefix = "spring.datasource.mysql")
    public DataSource getDataSource()  {
        DataSource dt= DataSourceBuilder.create().type(BasicDataSource.class).build();
        return dt;
    }


    @Bean
    @ConditionalOnMissingBean(name = "myAuditorAware")
    MyAuditorAware myAuditorAware() {
        return new MyAuditorAware();
    }


    /*@Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {

        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }*/

}