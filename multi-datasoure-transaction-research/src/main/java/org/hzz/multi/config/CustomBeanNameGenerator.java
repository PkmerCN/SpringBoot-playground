package org.hzz.multi.config;

import org.hzz.multi.annotations.MapperA;
import org.hzz.multi.annotations.MapperB;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AutowireCandidateQualifier;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.GenericBeanDefinition;

import java.lang.annotation.Annotation;

/**
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
    abstract void handleBeanDefinition(BeanDefinition definition);

    public static class MyBatisOneBeanNameGenerator extends CustomBeanNameGenerator {

        @Override
        String subfix() {
            return "one";
        }

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
