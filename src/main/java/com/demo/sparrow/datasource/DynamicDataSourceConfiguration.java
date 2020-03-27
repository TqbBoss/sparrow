package com.demo.sparrow.datasource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DynamicDataSourceConfiguration {
    public static final String MASTER_DATASOURCE = "MASTER_DATASOURCE";
    public static final String SLAVE_DATASOURCE = "SLAVE_DATASOURCE";

    @Bean(name = "master")
    @ConfigurationProperties(prefix = "sparrow.datasource.master")
    public DataSource masterDatasource(){
        return DataSourceBuilder.create().type(BasicDataSource.class).build();
    }

    @Bean(name = "slave")
    @ConfigurationProperties(prefix = "sparrow.datasource.slave")
    public DataSource slaveDatasource(){
        return DataSourceBuilder.create().type(BasicDataSource.class).build();
    }

    @Bean
    public AbstractRoutingDataSource proxyDataSource(){
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(MASTER_DATASOURCE, masterDatasource());
        targetDataSources.put(SLAVE_DATASOURCE, slaveDatasource());

        DynamicDataSourceHolder holder = new DynamicDataSourceHolder();
        holder.setDefaultTargetDataSource(masterDatasource());
        holder.setTargetDataSources(targetDataSources);
        return holder;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(proxyDataSource());
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception{
        Resource resource = new ClassPathResource("mybatis-config.xml");
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(proxyDataSource());
        sqlSessionFactoryBean.setConfigLocation(resource);
        return sqlSessionFactoryBean.getObject();
    }
}
