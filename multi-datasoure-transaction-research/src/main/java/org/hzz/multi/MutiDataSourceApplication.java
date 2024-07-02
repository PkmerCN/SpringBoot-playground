package org.hzz.multi;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.annotations.Mapper;
import org.hzz.multi.mapper.a.FriendMapper;
import org.hzz.multi.services.UserService;
import org.hzz.multi.services.UserServiceFactoryBean;
import org.hzz.multi.test.MyInterface;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.sql.DataSource;
import java.util.stream.Stream;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/1
 */
@SpringBootApplication(scanBasePackages = "org.hzz.multi")
@MapperScan(basePackages = "org.hzz.multi.mapper")
public class MutiDataSourceApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(MutiDataSourceApplication.class);

//        String[] beanNamesForType = applicationContext.getBeanNamesForType(DataSource.class);
//        Stream.of(beanNamesForType)
//                .forEach(System.out::println);

        String[] beanNamesForFriendMapper = applicationContext.getBeanNamesForType(FriendMapper.class);
        Stream.of(beanNamesForFriendMapper)
                .forEach(System.out::println);

//        String[] beanNamesForType1 = applicationContext.getBeanNamesForType(MyInterface.class);
//        System.out.println(beanNamesForType1.length);
    }
}
