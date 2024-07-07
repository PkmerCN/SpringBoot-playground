package org.hzz.redis.test;

import lombok.extern.slf4j.Slf4j;
import org.hzz.redis.dto.AddressDto;
import org.hzz.redis.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/7
 */
@SuppressWarnings(value = {"unchecked", "rawtypes"})
@Component
@Slf4j
public class TestCommandLine implements CommandLineRunner {

    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public void run(String... args) throws Exception {
        serialize();
        deserialize();
    }

    void serialize() {
        log.info("插入数据");
        UserDto userDto = new UserDto()
                .setDays(10)
                .setName("pkmer")
                .setCreateTime(LocalDateTime.now())
                .setJavaDeveloper(true)
                .setAddress(new AddressDto().setCity("桂林"));

        redisTemplate.opsForValue().set("user::"+userDto.getName(),userDto);
    }

    void deserialize(){
        Object o = redisTemplate.opsForValue().get("user::pkmer");
        System.out.println(o);
    }
}
