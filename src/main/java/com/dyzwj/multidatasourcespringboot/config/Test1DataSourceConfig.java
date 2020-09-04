package com.dyzwj.multidatasourcespringboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
//
@Configuration
@MapperScan(basePackages = "com.dyzwj.multidatasourcespringboot.mapper.test1",sqlSessionTemplateRef = "test1SqlSessionTemplate")
public class Test1DataSourceConfig {


    @Bean(name = "test1DataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.test1")
    public DataSource dataSource1(){
//        return DataSourceBuilder.create().build();
        return new DruidDataSource();
    }


    @Bean("test1SqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory1(@Qualifier("test1DataSource") DataSource dataSource) throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();

    }


    @Bean("test1DataSourceTransactionManager")
    @Primary
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("test1DataSource") DataSource dataSource){


        return new DataSourceTransactionManager(dataSource);
    }

    @Bean("test1SqlSessionTemplate")
    @Primary
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("test1SqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }







}
