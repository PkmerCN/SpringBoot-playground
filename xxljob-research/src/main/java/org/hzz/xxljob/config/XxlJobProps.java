package org.hzz.xxljob.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/8/1
 */
//@Component
@ConfigurationProperties("xxl.job")
@Data
public class XxlJobProps {
    private String accessToken;
    private String adminAddresses;
    private Executor executor;

    @Data
    public static class Executor{
        private String appname;
        private String logPath;
        private String address;
        private String ip;
        private Integer port;
        private Integer logRetentionDays;
    }

}
