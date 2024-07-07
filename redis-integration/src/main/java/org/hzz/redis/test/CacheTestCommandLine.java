package org.hzz.redis.test;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hzz.redis.core.RedisCache;
import org.hzz.redis.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * cache测试
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/7
 */
//@Component
@Order(6)
@Slf4j
public class CacheTestCommandLine implements CommandLineRunner {
    private final RedisCache redisCache;

    @Setter(onMethod_ = {@Autowired,@Lazy})
    private CacheTestCommandLine self;

    public CacheTestCommandLine(RedisCache cache){
        this.redisCache = cache;
    }
    @Override
    public void run(String... args) throws Exception {
        self.getUser(1L);
        UserDto user = self.getUser(1L);
        System.out.println(user);
    }

    @Cacheable(value = "items",key="#id")
    public UserDto getUser(Long id){
        log.info("执行查询用户");
        UserDto user = UserDataProvider.getUser();
        user.setId(id);
        System.out.println(user);
        return user;
    }
}
