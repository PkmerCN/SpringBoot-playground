package org.hzz.autowire.research.annotations;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/1
 */
@Target({ ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Qualifier        // 限定注入
public @interface MyTemp {
}
