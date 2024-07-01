package org.hzz.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/2
 */
@Configuration
@MapperScan(basePackages = "org.hzz.mapper.a")
public class MyBatisConfig1 {
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBeanA(@Qualifier("hikariDataSourceA") DataSource dataSource){
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        return factoryBean;
    }
}
