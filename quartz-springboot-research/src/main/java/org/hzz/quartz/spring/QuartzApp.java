package org.hzz.quartz.spring;

import jakarta.annotation.PostConstruct;
import org.hzz.quartz.example.example1.HelloJob;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/8/1
 */
@SpringBootApplication
public class QuartzApp {

    private Scheduler scheduler;

    public static void main(String[] args)  {
        SpringApplication app = new SpringApplication(QuartzApp.class);
        ConfigurableApplicationContext context = app.run(args);
        Scheduler bean = context.getBean(Scheduler.class);
        System.out.println(bean);
    }

    @Autowired
    public void setScheduler(Scheduler scheduler){
        this.scheduler = scheduler;
    }

    @PostConstruct
    public void init() throws SchedulerException {
        JobDetail job = newJob(HelloJob.class)
                .withIdentity("job1")
                .build();

        Trigger trigger = newTrigger()
                .withIdentity("trigger1")
                .startNow()
                .withSchedule(simpleSchedule().withIntervalInSeconds(3).repeatForever())
                .build();

        // 注册trigger
        scheduler.scheduleJob(job,trigger);
        scheduler.start();
    }
}
