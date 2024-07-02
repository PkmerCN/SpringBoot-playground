package org.hzz.autowire.research.annotations;

import org.hzz.autowire.research.register.MyRegister;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/2
 */

@Target({ ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(MyRegister.class)
public @interface MyScanner {
    String value();
}
