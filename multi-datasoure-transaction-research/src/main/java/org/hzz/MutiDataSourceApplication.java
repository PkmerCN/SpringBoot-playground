package org.hzz;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.stream.Stream;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/1
 */
@SpringBootApplication
public class MutiDataSourceApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(MutiDataSourceApplication.class);

        String[] beanNamesForType = applicationContext.getBeanNamesForType(HikariDataSource.class);

        Stream.of(beanNamesForType)
                .forEach(System.out::println);
    }
}
