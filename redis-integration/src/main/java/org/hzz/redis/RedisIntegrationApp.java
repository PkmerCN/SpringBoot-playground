package org.hzz.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/7
 */
@SpringBootApplication
@ComponentScan(basePackages = {"org.hzz.redis"},
        excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = "org\\.hzz\\.redis\\.test\\.basic\\..*"))
public class RedisIntegrationApp {
    public static void main(String[] args) {
        SpringApplication.run(RedisIntegrationApp.class);
    }
}
