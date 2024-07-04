package org.hzz.dynamic.config;

import com.zaxxer.hikari.HikariConfig;
import org.hzz.dynamic.datasource.DynamicRoutingDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

import static org.hzz.dynamic.datasource.DataSourceKeyConstants.*;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/4
 */
@Configuration
public class DataSourceConfig {

    @Bean(DB_A)
    @ConfigurationProperties(prefix = DB_A_PREFIX)
    public HikariConfig hikariConfigA(){
        return new HikariConfig();
    }

    @Bean(DB_B)
    @ConfigurationProperties(prefix = DB_B_PREFIX)
    public HikariConfig hikariConfigB(){
        return new HikariConfig();
    }

    @Bean
    public DynamicRoutingDataSource dataSource(Map<String,HikariConfig> maps){
        DynamicRoutingDataSource dynamicRoutingDataSource = new DynamicRoutingDataSource();

        Map<Object, Object> targetDbs = new HashMap<>();

        maps.forEach((beanName,config)->{
            // 为了简便，我直接使用beanName来切换
            DataSource dataSource = dynamicRoutingDataSource.createDataSource(config);
            targetDbs.put(beanName,dataSource);
        });
        dynamicRoutingDataSource.setTargetDataSources(targetDbs);
        return dynamicRoutingDataSource;
    }

}
