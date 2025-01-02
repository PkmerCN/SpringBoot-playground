package io.gitee.pkmer;

import io.gitee.pkmer.command.ACmd;
import io.gitee.pkmer.handler.CommandHandler;
import org.springframework.beans.BeansException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:1193094618@qq.com">pkmer</a>
 * <br>
 * <a href = "https://gitee.com/developeros/videos-online">Code Repository</a>
 * At 2025/1/2
 */
@SuppressWarnings(value = {"unchecked", "rawtypes"})
@SpringBootApplication
public class Application implements ApplicationContextAware {
    private ApplicationContext context;
    /**
     * 收集命令.class -> CommandHandler Bean
     */
    private final Map<Object, Object> cmdContainer = new HashMap<>();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * 取出bean，获取bean实现接口的泛型参数class
     * 用Map建立绑定关系
     */
    @Bean
    @Order(1)
    public CommandLineRunner testInterfaceGenericType(){
        return args -> {
            System.out.println("========注册命令处理器========");
            String[] beanNamesForCommandHandler = context.getBeanNamesForType(CommandHandler.class);
            for (String beanName : beanNamesForCommandHandler){
                // 获取命令处理器的bean
                CommandHandler bean = context.getBean(beanName, CommandHandler.class);
                // 获取命令处理器的泛型接口
                Type[] genericInterfaces = bean.getClass().getGenericInterfaces();
                // 获取第一个泛型接口也就是CommandHandler<T>接口
                ParameterizedType genericInterface = (ParameterizedType)genericInterfaces[0];
                // 获取泛型接口的泛型参数
                Type[] actualTypeArguments = genericInterface.getActualTypeArguments();
                Class<?> cmdType = (Class<?>)actualTypeArguments[0];
                cmdContainer.put(cmdType, bean);
            }
        };
    }


    @Bean
    @Order(2)
    public CommandLineRunner testCommandHandler() {
        return args -> {
            System.out.println("========测试命令处理器========");
            ACmd aCmd = ACmd.commandOf("命令的msg:准备加10", 10);
            // 直接从收集的绑定关系中获取命令处理器
            CommandHandler handler = (CommandHandler)this.cmdContainer.get(ACmd.class);
            handler.handle(aCmd);
        };
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("设置context");
        this.context = applicationContext;
    }
}
