package org.hzz.redis.test.basic;

import lombok.extern.slf4j.Slf4j;
import org.hzz.redis.core.RedisCache;
import org.hzz.redis.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * Set测试
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/7
 */
@SuppressWarnings(value = {"unchecked", "rawtypes"})
@Component
@Slf4j
@Order(4)
public class TestSetCommandLine implements CommandLineRunner {

    @Autowired
    private RedisCache redisCache;
    @Override
    public void run(String... args) throws Exception {
        serialize();
        deserialize();
    }

    void serialize() {
        Set<UserDto> set = UserDataProvider.getSet();
        redisCache.setSet("user::set",set);
    }

    void deserialize(){
        log.info("Set获取");
        Set<UserDto> set = redisCache.getSet("user::set", UserDto.class);
        System.out.println(set);
    }
}
