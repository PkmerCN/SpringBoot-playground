package org.hzz.multi.annotations;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

/**
 * 限定操作数据库B的Mapper Bean
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/3
 */
@Target({ ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Qualifier
public @interface MapperB {
}
