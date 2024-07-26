package org.hzz.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/26
 */
@Slf4j
public class TaskExecutorMain {
    public static void main(String[] args) {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(2); // 设置核心线程数
        taskExecutor.setMaxPoolSize(2); // 设置最大线程数
        taskExecutor.setQueueCapacity(2); // 设置队列容量
        taskExecutor.setThreadNamePrefix("pkmer-"); // 设置线程名前缀
        // 设置拒绝策略
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        taskExecutor.initialize(); // 初始化线程池

        for (int i = 1; i < 7; i++) {
            int finalI = i;
            taskExecutor.submit(() -> {
              try {
                  TimeUnit.SECONDS.sleep(1);
                  log.info("我是No.{}", finalI);
              } catch (InterruptedException e) {
                  throw new RuntimeException(e);
              }
          }) ;
        }

        taskExecutor.shutdown();
    }
}
