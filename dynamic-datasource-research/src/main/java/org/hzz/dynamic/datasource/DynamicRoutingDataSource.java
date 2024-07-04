package org.hzz.dynamic.datasource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;

/**
 * 这本身就是一个DataSource
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/4
 */
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        // 通过线程的ThreadLocal来获取routing key
        return DataSourceKeyContextHolder.getRoutingKey();
    }


    public DataSource createDataSource(HikariConfig config){
        return new HikariDataSource(config);
    }

}
