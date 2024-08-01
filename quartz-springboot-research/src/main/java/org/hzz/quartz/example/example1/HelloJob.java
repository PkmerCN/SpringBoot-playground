package org.hzz.quartz.example.example1;

import java.util.Date;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/30
 */
@Slf4j
public class HelloJob implements Job {
    public void execute(JobExecutionContext context)
            throws JobExecutionException {
        // Say Hello to the World and display the date/time
        log.info("Hello World! - " + new Date());
    }

}