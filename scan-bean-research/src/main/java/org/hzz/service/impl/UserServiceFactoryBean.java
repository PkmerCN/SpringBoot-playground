package org.hzz.service.impl;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/2
 */
@Component
public class UserServiceFactoryBean extends BaseUser implements FactoryBean<UserServiceImpl> {
    @Override
    public UserServiceImpl getObject() throws Exception {
        System.out.println("查看结果："+getApplicationContext());
        return new UserServiceImpl();
    }

    @Override
    public Class<?> getObjectType() {
        return UserServiceImpl.class;
    }
}
