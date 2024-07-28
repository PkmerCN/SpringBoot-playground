package org.hzz.redis.test.basic;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hzz.redis.core.RedisCache;
import org.hzz.redis.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
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
@Component
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
//        UserDto user1 = self.getUser(1L);
//        System.out.println(user1);
        UserDto user = self.getUser(1L);
        System.out.println(user);
        self.update(user);
//        self.deleteItemById(1L);
    }

    /**
     * 添加缓存
     * @param id
     * @return
     */
    @Cacheable(value = "items",key="#id")
    public UserDto getUser(Long id){
        log.info("执行查询用户");
        UserDto user = UserDataProvider.getUser();
        user.setId(id);
        return user;
    }

    /**
     * 删除缓存
     * @param id
     */
    @CacheEvict(value = "items", key = "#id")
    public void deleteItemById(Long id) {
        log.info("测试删除缓存");
    }

    /**
     * 更新缓存
     * @param dto
     * @return
     */
    @CachePut(value = "items", key = "#dto.id")
    public UserDto update(UserDto dto){
        log.info("更新缓存");
        dto.setName("黄壮壮");
        return dto;
    }
}
