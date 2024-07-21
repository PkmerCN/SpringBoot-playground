package org.hzz.sql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/22
 */
@SpringBootApplication
public class BatchUpdateApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(BatchUpdateApplication.class);
        application.run(args);
    }
}
