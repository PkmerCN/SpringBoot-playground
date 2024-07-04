package org.hzz.dynamic.annotations;

import java.lang.annotation.*;

/**
 * 切换数据源
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/4
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DS {
    String value();
}
