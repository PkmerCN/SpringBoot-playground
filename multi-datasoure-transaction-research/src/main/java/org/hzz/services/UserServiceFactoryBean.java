package org.hzz.services;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Service;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/2
 */
//@Service
public class UserServiceFactoryBean implements FactoryBean<UserService> {
    private int count = 0;
    @Override
    public UserService getObject() throws Exception {
        System.out.println("运行"+(++count));
        return new UserService();
    }

    @Override
    public Class<?> getObjectType() {
        return UserService.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
