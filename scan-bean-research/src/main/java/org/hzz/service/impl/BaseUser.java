package org.hzz.service.impl;

import org.springframework.context.ApplicationContext;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/2
 */
public abstract class BaseUser {
    private ApplicationContext applicationContext;

    //    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        System.out.println("会运行吗");
        this.applicationContext = applicationContext;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
