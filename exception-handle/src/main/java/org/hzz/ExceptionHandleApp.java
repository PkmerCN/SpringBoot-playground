package org.hzz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/5/30
 */
@SpringBootApplication
public class ExceptionHandleApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ExceptionHandleApp.class, args);
        Object error = applicationContext.getBean("error");
        System.out.println(error);
    }
}