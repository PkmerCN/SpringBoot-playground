package org.hzz.multi;

import org.hzz.multi.annotations.MapperA;
import org.hzz.multi.annotations.MapperB;
import org.hzz.multi.mapper.MyFriendMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.stream.Stream;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/1
 */
@SpringBootApplication(scanBasePackages = "org.hzz.multi")
public class MutiDataSourceApplication {


    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(MutiDataSourceApplication.class);


        String[] beanNamesForFriendMapper = applicationContext.getBeanNamesForType(MyFriendMapper.class);
        System.out.println(beanNamesForFriendMapper.length);
        Stream.of(beanNamesForFriendMapper)
                .forEach(System.out::println);


    }

    @Autowired

    public void setMyFriendMapper(@MapperA  MyFriendMapper friendMapperOne,
                                  @MapperB  MyFriendMapper friendMapperTwo){
        System.out.println(friendMapperOne);
        System.out.println(friendMapperTwo);
        System.out.println(friendMapperOne == friendMapperTwo);
    }
}
