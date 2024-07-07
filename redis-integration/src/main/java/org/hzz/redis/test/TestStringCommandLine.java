package org.hzz.redis.test;

import lombok.extern.slf4j.Slf4j;
import org.hzz.redis.core.RedisCache;
import org.hzz.redis.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 字符串与数字测试
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/7
 */
@SuppressWarnings(value = {"unchecked", "rawtypes"})
@Component
@Slf4j
@Order(2)
public class TestStringCommandLine implements CommandLineRunner {

    @Autowired
    private RedisCache redisCache;
    @Override
    public void run(String... args) throws Exception {
        serialize();
        deserialize();
    }

    void serialize() {
       redisCache.setObject("string::test","Hello 广州");
       redisCache.setObject("integer::test",123);
    }

    void deserialize(){
        log.info("string测试");
        String str = redisCache.getObject("string::test", String.class);
        System.out.println(str);
        Integer object = redisCache.getObject("integer::test", Integer.class);
        System.out.println(object);
    }
}
