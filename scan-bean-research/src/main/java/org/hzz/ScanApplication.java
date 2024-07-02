package org.hzz;

import org.hzz.service.UserServiceI;
import org.hzz.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/2
 */
@SpringBootApplication
public class ScanApplication {
    @Autowired
    private UserServiceImpl userService;
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ScanApplication.class);
        String[] beanNamesForType = context.getBeanNamesForType(UserServiceImpl.class);

        System.out.println(beanNamesForType.length);
        Arrays.stream(beanNamesForType).forEach(System.out::println);
    }
}
