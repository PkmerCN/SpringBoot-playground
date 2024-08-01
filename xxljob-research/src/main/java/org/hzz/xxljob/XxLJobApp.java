package org.hzz.xxljob;

import com.xxl.job.core.handler.annotation.XxlJob;
import org.hzz.xxljob.mapper.XxlJobMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/8/1
 */
@SpringBootApplication
public class XxLJobApp {
    private XxlJobMapper mapper;
    XxLJobApp(XxlJobMapper mapper){
        this.mapper = mapper;
    }
    public static void main(String[] args) {
        SpringApplication.run(XxLJobApp.class,args);
    }

    @EventListener
    public void listener(ApplicationReadyEvent event){
        System.out.println("Hello World " + mapper.select());
    }
}
