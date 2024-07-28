package org.hzz.redis.test.basic;

import lombok.extern.slf4j.Slf4j;
import org.hzz.redis.core.RedisCache;
import org.hzz.redis.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 测试对象
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/7
 */
@SuppressWarnings(value = {"unchecked", "rawtypes"})
@Component
@Slf4j
@Order(1)
public class TestCommandLine implements CommandLineRunner {

    @Autowired
    private RedisCache redisCache;
    @Override
    public void run(String... args) throws Exception {
        serialize();
        deserialize();
    }

    void serialize() {
        UserDto userDto = UserDataProvider.getUser();
        redisCache.setObject("user::"+userDto.getName(),userDto);
    }

    void deserialize(){
        UserDto userDto = redisCache.getObject("user::pkmer",UserDto.class);
        System.out.println(userDto);
    }
}
