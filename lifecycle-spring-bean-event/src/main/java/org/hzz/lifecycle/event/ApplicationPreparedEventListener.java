package org.hzz.lifecycle.event;

import lombok.extern.slf4j.Slf4j;
import org.hzz.lifecycle.factory.ConnectionDetails;
import org.hzz.lifecycle.factory.MyFactories;
import org.hzz.lifecycle.factory.MyFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.function.Supplier;

/**
 * 不能注册为bean，因为监听不到ApplicationPreparedEvent事件
 * 在某些情况下，事件会在 ApplicationListener 注册之前发布，导致无法监听到该事件。
 * 使用 Spring Boot 内置的事件监听器
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/8
 */
@Slf4j
public class ApplicationPreparedEventListener implements ApplicationListener<ApplicationPreparedEvent> {

    private final MyFactories factories;
    public ApplicationPreparedEventListener(){
        this(new MyFactories());
    }

    public ApplicationPreparedEventListener(MyFactories factories){
        this.factories = factories;
    }



    @Override
    public void onApplicationEvent(ApplicationPreparedEvent event) {
        log.info("监听到ApplicationPreparedEvent");
        ConfigurableApplicationContext applicationContext = event.getApplicationContext();
        if(applicationContext instanceof BeanDefinitionRegistry registry){
            log.info("准备注册beandefinition");
            registerConnectionDetails(registry);
        }
    }

    private void registerConnectionDetails(BeanDefinitionRegistry registry){
        this.factories.getFactories().forEach(factory -> {
            register(registry,factory.getConectionDetails());
        });
    }

    @SuppressWarnings("unchecked")
    private <T> void register(BeanDefinitionRegistry registry, ConnectionDetails connectionDetails){
        String beanName = connectionDetails.getClass().getSimpleName();
        Class<T> type = (Class<T>) connectionDetails.getClass();
        Supplier<T> beanSupplier = () -> (T)connectionDetails;
        registry.registerBeanDefinition(beanName,new RootBeanDefinition(type,beanSupplier));
    }
}
