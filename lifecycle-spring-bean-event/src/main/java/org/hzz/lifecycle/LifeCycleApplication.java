package org.hzz.lifecycle;

import lombok.extern.slf4j.Slf4j;
import org.hzz.lifecycle.event.ApplicationPreparedEventListener;
import org.hzz.lifecycle.factory.ConnectionDetails;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.stream.Stream;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/8
 */
@SpringBootApplication
@Slf4j
public class LifeCycleApplication {
    public static void main(String[] args) {
        log.info("开始");
        SpringApplication springApplication = new SpringApplication(LifeCycleApplication.class);
        /**
         * 使用 Spring Boot 内置的事件监听器
         * 目前我使用了spring.factories
         */
        // springApplication.addListeners(new ApplicationPreparedEventListener());

        ConfigurableApplicationContext applicationContext = springApplication.run(args);
        String[] beanNamesForConnectionDetails = applicationContext.getBeanNamesForType(ConnectionDetails.class);
        for(String beanName: beanNamesForConnectionDetails){
            Object bean = applicationContext.getBean(beanName);
            System.out.println(bean);
        }
        applicationContext.close();
        log.info("结束");
    }
}
