package org.hzz.multi.config;

import org.hzz.multi.annotations.TransactionTemplateA;
import org.hzz.multi.annotations.TransactionTemplateB;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

/**
 * 配置事务平台管理器
 * 和TransactionTemplate编程式事务
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/3
 */
@Configuration
public class TransactionTemplateConfig {

    @Configuration
    static class TransactionTemplateAConfig{
        @Bean
        DataSourceTransactionManager dataSourceTransactionManagerA(@Qualifier("hikariDataSourceA") DataSource dataSource){
            DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
            dataSourceTransactionManager.setDataSource(dataSource);
            return dataSourceTransactionManager;
        }

        /**
         * @TransactionTemplateA是自定义注解
         * 就是一个限定注入，类似@LoadBalance
         */
        @Bean
        @TransactionTemplateA
        TransactionTemplate transactionTemplateOne(@Qualifier("dataSourceTransactionManagerA")
                                                   PlatformTransactionManager platformTransactionManager){

            TransactionTemplate transactionTemplate = new TransactionTemplate();
            transactionTemplate.setTransactionManager(platformTransactionManager);
            return transactionTemplate;
        }
    }

    @Configuration
    static class TransactionTemplateBConfig{
        @Bean
        DataSourceTransactionManager dataSourceTransactionManagerB(@Qualifier("hikariDataSourceB") DataSource dataSource){
            DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
            dataSourceTransactionManager.setDataSource(dataSource);
            return dataSourceTransactionManager;
        }

        @Bean
        @TransactionTemplateB
        TransactionTemplate transactionTemplateTwo(@Qualifier("dataSourceTransactionManagerB")
                                                   PlatformTransactionManager platformTransactionManager){

            TransactionTemplate transactionTemplate = new TransactionTemplate();
            transactionTemplate.setTransactionManager(platformTransactionManager);
            return transactionTemplate;
        }
    }

}
