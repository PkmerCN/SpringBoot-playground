package org.hzz.task.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/27
 */

@Slf4j
@EnableAsync
@EnableScheduling
@SpringBootApplication
public class SchedulerApplication {
    static AtomicInteger count = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {
        SpringApplication application = new SpringApplication(SchedulerApplication.class);
        application.run(args);
    }

//    @Scheduled(fixedDelay = 3, timeUnit = TimeUnit.SECONDS)
    @Scheduled(cron = "*/3 * * * * *")
    public void helloWorld() throws InterruptedException {
        log.info("No.{}",count.getAndIncrement());
        TimeUnit.SECONDS.sleep(5);
        log.info("是：{}",Thread.currentThread().isDaemon() ? "守护线程":"用户线程");

    }
}
