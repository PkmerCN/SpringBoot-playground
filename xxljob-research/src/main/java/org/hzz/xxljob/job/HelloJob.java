package org.hzz.xxljob.job;

import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/8/1
 */
@Component
@Slf4j
public class HelloJob {
    private final AtomicInteger count = new AtomicInteger(0);

    // @XxlJob里面的内容helloJob要与服务端xxljob配置的任务一样
    @XxlJob("helloJob")
    public void helloJob(){
        log.info("执行Hello xxl job {}次",count.incrementAndGet());
    }
}
