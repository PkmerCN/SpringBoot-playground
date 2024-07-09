package org.hzz.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/8
 */
@Component
@Slf4j
public class UserService implements CommandLineRunner, InitializingBean,
        SmartInitializingSingleton, DisposableBean, ApplicationContextAware {

    @Autowired
    private ApplicationContext context;

    @Autowired
    @Lazy
    private UserService service;

    static {
        log.info("UserService Static");
    }

    public UserService(ApplicationContext context){
        log.info("构造函数");
    }

    @PostConstruct
    public void init(){
        log.info("@PostConstruct方法");
    }

    @PreDestroy
    public void end(){
        log.info("@PreDestroy方法");
    }

    @Autowired
    public void setContext(ApplicationContext context){
        log.info("Setter方法");
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("CommandLineRunner");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("InitializingBean#afterPropertiesSet");
    }

    @Override
    public void afterSingletonsInstantiated() {
        log.info("SmartInitializingSingleton#afterSingletonsInstantiated");
    }

    @Override
    public void destroy() throws Exception {
        log.info("DisposableBean#destroy");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("ApplicationContextAware#setApplicationContext");
    }
}
