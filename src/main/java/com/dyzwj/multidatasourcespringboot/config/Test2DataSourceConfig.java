package com.dyzwj.multidatasourcespringboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.dyzwj.multidatasourcespringboot.mapper.test2",sqlSessionTemplateRef = "test2SqlSessionTemplate")
public class Test2DataSourceConfig {



    @Bean(name = "test2DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.test2")
    public DataSource dataSource2(){
//        return DataSourceBuilder.create().build();
        return new DruidDataSource();
    }

    @Bean("test2SqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("test2DataSource") DataSource dataSource) throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }


    @Bean("test2DataSourceTransactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("test2DataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean("test2SqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("test2SqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }





}
