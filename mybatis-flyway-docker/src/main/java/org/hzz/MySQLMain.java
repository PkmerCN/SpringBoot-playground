package org.hzz;

import org.hzz.mapper.UserAnnotationMapper;
import org.hzz.mapper.UserXMLMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/1
 */
@SpringBootApplication
//@MapperScan("org.hzz.mapper")
public class MySQLMain implements CommandLineRunner {

    @Autowired
    private UserAnnotationMapper userAnnotationMapper;

    @Autowired
    private UserXMLMapper userXMLMapper;

    public static void main(String[] args) {
        SpringApplication.run(MySQLMain.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(userAnnotationMapper.getUserByCellPhone("17801054490"));
        System.out.println(userXMLMapper.getAllUsers());
    }
}