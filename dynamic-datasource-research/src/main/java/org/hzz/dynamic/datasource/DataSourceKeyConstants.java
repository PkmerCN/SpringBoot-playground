package org.hzz.dynamic.datasource;

/**
 * 作为BeanName和Routing key {@link DynamicRoutingDataSource}
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/4
 */
public interface DataSourceKeyConstants {

    String DB_A = "DB_A";
    String DB_B = "DB_B";

    String DB_A_PREFIX = "spring.datasource.hikari-a";
    String DB_B_PREFIX = "spring.datasource.hikari-b";
}
