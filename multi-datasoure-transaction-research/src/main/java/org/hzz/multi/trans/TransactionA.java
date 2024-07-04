package org.hzz.multi.trans;

import org.hzz.multi.annotations.TransactionTemplateA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.concurrent.Callable;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/4
 */
@Component
public class TransactionA {

//    @Autowired
//    @TransactionTemplateA
//    private TransactionTemplate transactionTemplate;
//    public <V> V inTransaction(Callable<V> callable){
//        return transactionTemplate.execute(status -> {
//            try {
//                return callable.call();
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        });
//    }
    @Transactional(transactionManager = "dataSourceTransactionManagerA")
    public <V> V inTransaction(Callable<V> callable){
        try {
            return callable.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
