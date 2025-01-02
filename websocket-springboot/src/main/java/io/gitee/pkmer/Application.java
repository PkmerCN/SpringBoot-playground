package io.gitee.pkmer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

/**
 * @author <a href="mailto:1193094618@qq.com">pkmer</a>
 * <br>
 * <a href = "https://gitee.com/developeros/videos-online">Code Repository</a>
 * At 2024/10/24
 */
@SpringBootApplication
@EnableWebSocket
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
