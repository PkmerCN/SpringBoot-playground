package org.hzz.sql.utils;

import java.util.concurrent.TimeUnit;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/22
 */
public class TimeUtil {

    public static void testTime(Integer count,Runnable runnable){
        long startTime = System.nanoTime();
        for(int i = 0; i < count; i++){
            runnable.run();
        }
        long durationNanos = System.nanoTime() - startTime;

        // 将纳秒转换为毫秒和秒
        double durationMillis = durationNanos / 1_000_000.0;
        double durationSeconds = durationNanos / 1_000_000_000.0;

        System.out.println("执行" + count + "次所消耗的时间: " + durationNanos + " ns(纳秒)");
        System.out.println("执行" + count + "次所消耗的时间: " + durationMillis + " ms(毫秒)");
        System.out.println("执行" + count + "次所消耗的时间: " + durationSeconds + " s(秒)");
    }

    public static void main(String[] args) {
        testTime(5,()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
