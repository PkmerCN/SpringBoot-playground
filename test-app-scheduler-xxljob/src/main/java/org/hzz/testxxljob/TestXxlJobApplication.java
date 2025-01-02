package org.hzz.testxxljob;

//import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
//import org.hzz.scheduler.autoconfig.XxlJobAutoConfig;
//import org.hzz.scheduler.xxljob.XxlJobProps;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/8/1
 */
@SpringBootApplication
public class TestXxlJobApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext appContext = SpringApplication.run(TestXxlJobApplication.class, args);
//
//        String[] beanNamesXxlJobAutoConfig = appContext.getBeanNamesForType(XxlJobAutoConfig.class);
//        String[] beanNamesForXxlJobProps = appContext.getBeanNamesForType(XxlJobProps.class);
//        System.out.println(beanNamesXxlJobAutoConfig.length); // 1
//        System.out.println(beanNamesForXxlJobProps.length);   // 1
    }
}
