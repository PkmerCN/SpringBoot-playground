package org.hzz.multi.trans;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.Callable;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/4
 */
@Component
public class TransactionB {

    @Transactional(transactionManager = "dataSourceTransactionManagerB")
    public <V> V inTransaction(Callable<V> callable){
        try {
            return callable.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
