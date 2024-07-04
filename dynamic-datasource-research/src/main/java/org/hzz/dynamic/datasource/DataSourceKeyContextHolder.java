package org.hzz.dynamic.datasource;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/4
 */
public class DataSourceKeyContextHolder {
    public static ThreadLocal<String> dbKey = new ThreadLocal<>();

    public static void addRoutingKey(String routingKey){
        dbKey.set(routingKey);
    }

    public static String getRoutingKey(){
        return dbKey.get();
    }

    public static void clear(){
        dbKey.remove();
    }
}
