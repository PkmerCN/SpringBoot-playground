package org.hzz.multi;

import org.hzz.multi.annotations.MapperA;
import org.hzz.multi.annotations.MapperB;
import org.hzz.multi.entity.Friend;
import org.hzz.multi.mapper.MyFriendMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;
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
//
        String[] beanNamesForFriendMapper = applicationContext.getBeanNamesForType(MyFriendMapper.class);
        System.out.println(beanNamesForFriendMapper.length);
        Stream.of(beanNamesForFriendMapper)
                .forEach(System.out::println);
//
//        System.out.println("========================================");
//
//        String[] beanNamesForTemplates = applicationContext.getBeanNamesForType(TransactionTemplate.class);
//        System.out.println(beanNamesForTemplates.length);
//        Stream.of(beanNamesForTemplates)
//                .forEach(System.out::println);
    }

//    @Autowired
//    public void setMyFriendMapper(@MapperA  MyFriendMapper friendMapperOne,
//                                  @MapperB  MyFriendMapper friendMapperTwo){
//        System.out.println(friendMapperOne);
//        System.out.println(friendMapperTwo);
//        System.out.println(friendMapperOne == friendMapperTwo);
//
//        List<Friend> friends1 = friendMapperOne.selectFriends();
//        List<Friend> friends2 = friendMapperTwo.selectFriends();
//
//        System.out.println(friends1);
//        System.out.println(friends2);
//
//    }
}
