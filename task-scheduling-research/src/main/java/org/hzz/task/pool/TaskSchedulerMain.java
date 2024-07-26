package org.hzz.task.pool;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.time.Instant;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/26
 */
@Slf4j
public class TaskSchedulerMain {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(2);
        taskScheduler.setThreadNamePrefix("pkmer-");
        taskScheduler.setWaitForTasksToCompleteOnShutdown(true);
        taskScheduler.initialize();

        log.info("current");
        // 延迟任务
        taskScheduler.schedule(
                ()-> log.info("hello"),
                Instant.now().plusSeconds(3));

        // main线程阻塞，方便测试看效果
        Thread.currentThread().join(Integer.MAX_VALUE);
//        taskScheduler.shutdown();
    }
}
