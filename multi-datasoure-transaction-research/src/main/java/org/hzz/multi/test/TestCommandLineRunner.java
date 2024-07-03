package org.hzz.multi.test;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hzz.multi.annotations.*;
import org.hzz.multi.mapper.MyFriendMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/3
 */
@Component
@Slf4j
public class TestCommandLineRunner implements CommandLineRunner{

    /**
     * 解决AOP失效问题
     * 方便测试{@link TestCommandLineRunner#addFriendWithAnnotion}
     */
    @Autowired
    @Lazy
    private TestCommandLineRunner self;

    @Autowired
    @TransactionTemplateA
    private TransactionTemplate transactionTemplateA;

    @Autowired
    @TransactionTemplateB
    private TransactionTemplate transactionTemplateB;

    @Setter(onMethod_ = {@Autowired,@MapperA})
    private MyFriendMapper myFriendMapperA;

    @Setter(onMethod_ = {@Autowired,@MapperB})
    private MyFriendMapper myFriendMapperB;



    @Override
    public void run(String... args) throws Exception {
//        addFriendsWithTemplate();
        self.addFriendWithAnnotion();
    }



    private void addFriendsWithTemplate(){
        transactionTemplateA.execute(status1 ->
           transactionTemplateB.execute(status2 -> {
               int r1 = myFriendMapperA.insert("dog");
               int r2 = myFriendMapperB.insert("dog");
               log.info("r1 = {} r2 = {}",r1,r2);
               if(r1 == 1 || r2 == 1){
                   status1.setRollbackOnly();
               }
               return true;
            })
        );
    }


    @MultiTransaction({"A","B"})
    public void addFriendWithAnnotion(){
        int r1 = myFriendMapperA.insert("cat");
        int r2 = myFriendMapperB.insert("cat");
//        throw new RuntimeException("失败");
    }


}
