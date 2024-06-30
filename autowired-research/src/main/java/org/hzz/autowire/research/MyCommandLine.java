package org.hzz.autowire.research;

import org.hzz.autowire.research.annotations.MyTemp;
import org.hzz.autowire.research.order.OrderService;
import org.hzz.autowire.research.services.MyTransactionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/30
 */
@Component
public class MyCommandLine implements CommandLineRunner {

    @Autowired(required = false)
    private Optional<OrderService> orderService;

   // @Autowired(required = false)
   // private List<OrderService> orderServices; // 会返回null

    // 使用下面的包装
    @Autowired(required = false)
    Optional<List<OrderService>> orderServices;


    @Override
    public void run(String... args) throws Exception {
        orderService.ifPresent(o->{
            System.out.println("开始做order业务");
        });


        orderServices.ifPresent(order -> {
            // ...
        });
    }

}
/**
 * Bean名称：templateOne
 * Hello One
 * Bean名称：templateTwo
 * Hello Two
 */