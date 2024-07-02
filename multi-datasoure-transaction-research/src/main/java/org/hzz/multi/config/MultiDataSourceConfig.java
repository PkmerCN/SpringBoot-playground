package org.hzz.multi.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/1
 */
@Configuration
public class MultiDataSourceConfig {
    /**
     * 不用@Bean方法的方式，是因为自动生成autofiguration-meta
     * 在application.yaml中检测不到配置
     *     @Bean
     *     @ConfigurationProperties(prefix = "spring.datasource.hikari-a")
     *     HikariDataSource dataSourceA(){
     *         return new HikariDataSource();
     *     }
     */

    // bean名称会变成multiDataSourceConfig.HikariDataSourceA
    // 所以我们要手动指定bean Name
    @Component("hikariDataSourceA")
    @ConfigurationProperties(prefix = "spring.datasource.hikari-a")
    static class HikariDataSourceA extends HikariDataSource{
    }
//
//
//    @Component("hikariDataSourceB")
//    @ConfigurationProperties(prefix = "spring.datasource.hikari-b")
//    static class HikariDataSourceB extends HikariDataSource{
//    }
}
