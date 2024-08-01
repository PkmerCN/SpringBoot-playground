package org.hzz.xxljob.config;

import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/8/1
 */
@Configuration
@Slf4j
@EnableConfigurationProperties(XxlJobProps.class)
public class XxlJobConfig {
    @Bean
    public XxlJobSpringExecutor xxlJobExecutor(XxlJobProps props) {
        log.info(">>>>>>>>>>> xxl-job config init.");
        XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
        String adminAddresses = props.getAdminAddresses();
        if (adminAddresses != null && !adminAddresses.isBlank()) {
            xxlJobSpringExecutor.setAdminAddresses(adminAddresses);
        }
        XxlJobProps.Executor executor = props.getExecutor();
        if (executor != null) {
            if (executor.getAppname() != null)
                xxlJobSpringExecutor.setAppname(executor.getAppname());
            if (executor.getIp() != null)
                xxlJobSpringExecutor.setIp(executor.getIp());
            if (executor.getPort() != null)
                xxlJobSpringExecutor.setPort(executor.getPort());
            if (executor.getLogPath() != null)
                xxlJobSpringExecutor.setLogPath(executor.getLogPath());
            if (executor.getLogRetentionDays() != null)
                xxlJobSpringExecutor.setLogRetentionDays(executor.getLogRetentionDays());
        }
        if (props.getAccessToken() != null)
            xxlJobSpringExecutor.setAccessToken(props.getAccessToken());
        log.info(">>>>>>>>>>> xxl-job config end.");
        return xxlJobSpringExecutor;
    }
}
