package org.hzz.multi.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/2
 */
@Configuration
public class MyBatisConfig {

    @Configuration
    @MapperScan(basePackages = "org.hzz.multi.mapper",annotationClass = Mapper.class,sqlSessionFactoryRef = "sqlSessionFactoryBeanA",nameGenerator = CustomBeanNameGenerator.MyBatisOneBeanNameGenerator.class)
    static class MyBatisConfigOne{
        @Bean
        public SqlSessionFactoryBean sqlSessionFactoryBeanA(@Qualifier("hikariDataSourceA") DataSource dataSource){
            SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
            factoryBean.setDataSource(dataSource);
            return factoryBean;
        }
    }

    @Configuration
    @MapperScan(basePackages = "org.hzz.multi.mapper", annotationClass = Mapper.class,sqlSessionFactoryRef = "sqlSessionFactoryBeanB",nameGenerator = CustomBeanNameGenerator.MyBatisTwoBeanNameGenerator.class)
    static class MyBatisConfigTwo{
        @Bean
        public SqlSessionFactoryBean sqlSessionFactoryBeanB(@Qualifier("hikariDataSourceB") DataSource dataSource){
            SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
            factoryBean.setDataSource(dataSource);
            return factoryBean;
        }
    }

}
