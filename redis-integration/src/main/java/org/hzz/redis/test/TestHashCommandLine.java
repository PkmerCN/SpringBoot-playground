package org.hzz.redis.test;

import lombok.extern.slf4j.Slf4j;
import org.hzz.redis.core.RedisCache;
import org.hzz.redis.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/7
 */
@SuppressWarnings(value = {"unchecked", "rawtypes"})
@Component
@Slf4j
public class TestHashCommandLine implements CommandLineRunner {

    @Autowired
    private RedisCache redisCache;
    @Override
    public void run(String... args) throws Exception {
        serialize();
        deserialize();
    }

    void serialize() {
        Map<String, UserDto> map = UserDataProvider.getMap();
        redisCache.setMap("user::hash",map);
    }

    void deserialize(){
        log.info("获取Map");
        Map<String, UserDto> map = redisCache.getMap("user::hash", UserDto.class);
        System.out.println(map);

        UserDto pkmer = redisCache.getMapValue("user::hash", "pkmer", UserDto.class);
        System.out.println(pkmer);
    }
}
