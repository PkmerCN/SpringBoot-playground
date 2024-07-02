package org.hzz.autowire.research;

import org.hzz.autowire.research.annotations.MyScanner;
import org.hzz.autowire.research.annotations.MyTemp;
import org.hzz.autowire.research.services.MyTransactionTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.util.stream.Stream;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/30
 */
@SpringBootApplication
@MyScanner("pkmer hello world")
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class);
        // 获取类型对应的bean名称
        String[] beanNamesForType = context.getBeanNamesForType(MyTransactionTemplate.class);

        System.out.println("打印RTransactionTemplate类型Bean的名字");
        Stream.of(beanNamesForType)
                .forEach(System.out::println);
    }

    @Bean
    @Primary
    MyTransactionTemplate templateOne(){
        return new MyTransactionTemplate("Hello One");
    }

    @Bean
    @MyTemp
    MyTransactionTemplate templateTwo(){
        return new MyTransactionTemplate("Hello Two");
    }

}
