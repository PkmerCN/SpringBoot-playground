package org.hzz.dynamic.aspectj;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.hzz.dynamic.annotations.DS;
import org.hzz.dynamic.datasource.DataSourceKeyContextHolder;
import org.springframework.stereotype.Component;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/4
 */
@Aspect
@Component
@Slf4j
public class DataSourceAspect {

    @Pointcut("@annotation(ds)")
    public void pointcut(DS ds){}

    @Around(value = "pointcut(ds)", argNames = "joinPoint,ds")
    public Object around(ProceedingJoinPoint  joinPoint, DS ds){
        try{
            String value = ds.value();
            DataSourceKeyContextHolder.addRoutingKey(value);
            log.info("测试@DS的value = {}",DataSourceKeyContextHolder.getRoutingKey());
            return joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }finally {
            // 防止ThreadLocal内存泄漏
            DataSourceKeyContextHolder.clear();
        }
    }
}
