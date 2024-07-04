package org.hzz.multi.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.hzz.multi.annotations.MultiTransaction;
import org.hzz.multi.trans.TransactionA;
import org.hzz.multi.trans.TransactionB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.Callable;
import java.util.stream.Stream;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/4
 */
@Aspect
@Component
public class MutiTransactionAspect{

    @Autowired
    private TransactionA transactionA;
    @Autowired
    private TransactionB transactionB;



    @Pointcut("@annotation(multiTransaction)")
    public void pointcut(MultiTransaction multiTransaction){}




    @Around(value = "pointcut(multiTransaction)", argNames = "joinPoint,multiTransaction")
    public Object around(ProceedingJoinPoint joinPoint, MultiTransaction multiTransaction) throws Exception {

        String[] value = multiTransaction.value();
        Callable<Object> callable = () -> {
            try {
                return joinPoint.proceed();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        };

        Callable<Object> reduce = Stream.of(value)
                .reduce(callable, (c, v) ->
                   switch (v) {
                        case "A" -> () -> transactionA.inTransaction(c);
                        case "B" -> () -> transactionB.inTransaction(c);
                        default -> throw new IllegalStateException("Unexpected value: " + v);
                   }
                , (r1, r2) -> r2);

        return reduce.call();
    }

    /**
     * 不能在这里写@Transaction.事务会不生效的。因为这是一个Aspectj类。
     * 即使用来
     * @Autowired
     * @Lazy
     * private MutiTransactionAspect self;
     * 也不会生效
     */

//    @Transactional(transactionManager = "dataSourceTransactionManagerA")
//    protected <V> V inTransactionA(Callable<V> callable){
//        try {
//            return callable.call();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }

}
