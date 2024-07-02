package org.hzz.autowire.research.register;

import org.hzz.autowire.research.Application;
import org.hzz.autowire.research.order.OrderService;
import org.hzz.autowire.research.services.MyTransactionTemplate;
import org.springframework.context.ApplicationContext;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/2
 */
public class UserService {
//    public UserService(){
//        System.out.println("构造函数运行");
//    }

    /**
     * 这里OrderService是一个接口
     * @param clazz
     */
//    public UserService(Class<OrderService> clazz){
//        System.out.println("带参数构造函数运行 "+ clazz);
//    }

    /**
     * @param applicationContext spring的自动注入
     * @param number1 我们在BeanDefinition中设置的构造方法参数
     * @param clazz 我们在BeanDefinition中设置的构造方法参数
     * @param number2 我们在BeanDefinition中设置的构造方法参数
     */
    public UserService(ApplicationContext applicationContext,Integer number1,Class<OrderService> clazz,Integer number2){
        System.out.println("带参数构造函数运行 ");
        System.out.println("类型： " + clazz);
        System.out.println("number1: " + number1);
        System.out.println("number2: " + number2);
        System.out.println("context: " + applicationContext);
    }

    /**
     * 设置了AUTOWIRE_BY_TYPE
     * 会执行这个方法
     */
    public void setMyApplicatioinContext(ApplicationContext applicationContext){
        System.out.println("执行setter方法: "+applicationContext);
    }
}
