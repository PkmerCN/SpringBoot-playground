package org.hzz.services;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/2
 */
//@Service
//@Scope("prototype")
public class UserService {
    public UserService(){
        System.out.println("被创建");
    }
}
