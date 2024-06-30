package org.hzz.autowire.research.services;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/30
 */
public class MyTransactionTemplate {
    private String msg;
    public MyTransactionTemplate(String msg){
        this.msg = msg;
    }

    public void say(){
        System.out.println(msg);
    }
}
