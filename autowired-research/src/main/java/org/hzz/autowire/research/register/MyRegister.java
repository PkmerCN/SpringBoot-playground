package org.hzz.autowire.research.register;

import org.hzz.autowire.research.annotations.MyScanner;
import org.hzz.autowire.research.order.OrderService;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/2
 */
public class MyRegister implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(MyScanner.class.getName());
        System.out.println(annotationAttributes);

        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
        // 设置Bean对应的类，用于实例化
        beanDefinition.setBeanClass(UserService.class);
//        RootBeanDefinition beanDefinition = new RootBeanDefinition();
//        beanDefinition.setBeanClass(UserService.class);
        // 自动装配（自动注入依赖）
//        beanDefinition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
        // 给有参构造函数设置参数
        //beanDefinition.getConstructorArgumentValues().addGenericArgumentValue("org.hzz.autowire.research.order.OrderService");
        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(OrderService.class);
        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(10);
        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(20);

        // 设置属性
       beanDefinition.getPropertyValues().add("pkmerMessage","Happy Coding");

        registry.registerBeanDefinition("myUserService",beanDefinition);
    }
}
