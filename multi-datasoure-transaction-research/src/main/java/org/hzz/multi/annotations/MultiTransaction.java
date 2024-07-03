package org.hzz.multi.annotations;

import java.lang.annotation.*;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/4
 */
@Target({ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MultiTransaction {
    String[] value();
}
