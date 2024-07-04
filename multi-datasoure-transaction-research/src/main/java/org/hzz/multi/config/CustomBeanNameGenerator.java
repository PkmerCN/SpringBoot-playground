package org.hzz.multi.config;

import org.hzz.multi.annotations.MapperA;
import org.hzz.multi.annotations.MapperB;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AutowireCandidateQualifier;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.GenericBeanDefinition;

import java.lang.annotation.Annotation;

/**
 * 实现BeanName
 * 这里主要是为了区分两个数据库
 * 比如FriendMapper
 * A: FriendMapper_one
 * B: FriendMapper_two
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/3
 */
public abstract class CustomBeanNameGenerator implements BeanNameGenerator {
    @Override
    public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
        handleBeanDefinition(definition);
        String className = definition.getBeanClassName();
        if (className != null) {
            return className + "_" + subfix();
        }
        return definition.getFactoryBeanName() + "_" + definition.getFactoryMethodName() + "_" + subfix();
    }


    abstract String subfix();

    /**
     * 处理beandefinition
     * 加入限定注入的注解
     * @param definition
     */
    abstract void handleBeanDefinition(BeanDefinition definition);

    public static class MyBatisOneBeanNameGenerator extends CustomBeanNameGenerator {

        @Override
        String subfix() {
            return "one";
        }

        /**
         * 加入限定注入@MapperA
         */
        @Override
        void handleBeanDefinition(BeanDefinition definition) {
            MapperA mapperA =  new MapperA(){
                @Override
                public Class<? extends Annotation> annotationType() {
                    return MapperA.class;
                }
            };

            AutowireCandidateQualifier qualifier = new AutowireCandidateQualifier(MapperA.class, mapperA);
            ((GenericBeanDefinition)definition).addQualifier(qualifier);
        }
    }

    public static class MyBatisTwoBeanNameGenerator extends CustomBeanNameGenerator {

        @Override
        String subfix() {
            return "two";
        }

        /**
         * 加入限定注入@MapperB
         */
        @Override
        void handleBeanDefinition(BeanDefinition definition) {

            MapperB mapperB =  new MapperB(){
                @Override
                public Class<? extends Annotation> annotationType() {
                    return MapperB.class;
                }
            };

            AutowireCandidateQualifier qualifier = new AutowireCandidateQualifier(MapperB.class, mapperB);
            ((GenericBeanDefinition)definition).addQualifier(qualifier);
        }
    }
}
