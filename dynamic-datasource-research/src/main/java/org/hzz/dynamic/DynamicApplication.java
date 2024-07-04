package org.hzz.dynamic;

import org.hzz.dynamic.mapper.FriendMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.stream.Stream;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/4
 */
@SpringBootApplication
public class DynamicApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(DynamicApplication.class);

        String[] beanNamesForType = applicationContext.getBeanNamesForType(FriendMapper.class);
        Stream.of(beanNamesForType)
                .forEach(System.out::println);
    }
}
