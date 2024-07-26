package org.hzz.task.pool;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/26
 */
@Slf4j
public class TaskSchedulerFixRateMain {
    static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(2);
        taskScheduler.setThreadNamePrefix("pkmer-");
        taskScheduler.setWaitForTasksToCompleteOnShutdown(true);
        taskScheduler.initialize();

        log.info("current");
        // 延迟任务3
        taskScheduler.scheduleAtFixedRate(
                () -> {
                    try {
                        int index = count.getAndIncrement();
                        log.info("No.{} start", index);
                        TimeUnit.SECONDS.sleep(5);
                        log.info("No.{} end", index);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }, Duration.ofSeconds(3));

        // 让main线程不结束
        Thread.currentThread().join(Integer.MAX_VALUE);
//        taskScheduler.shutdown();
    }
}
