package org.hzz.redis.config;

import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.filter.ContextAutoTypeBeforeHandler;
import com.alibaba.fastjson2.support.config.FastJsonConfig;
import com.alibaba.fastjson2.support.spring6.data.redis.FastJsonRedisSerializer;
import com.alibaba.fastjson2.support.spring6.data.redis.GenericFastJsonRedisSerializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.SimpleCacheResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;
import java.util.Objects;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/7
 */
@Configuration
@Slf4j
@EnableCaching
public class RedisConfig implements CachingConfigurer {

    private final RedisConnectionFactory redisConnectionFactory;

    public RedisConfig(RedisConnectionFactory connectionFactory){
        this.redisConnectionFactory = connectionFactory;
    }
    @Bean
    @Primary
    RedisTemplate<Object, Object> redisTemplate() {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        // 配置fastjson
        FastJsonRedisSerializer<Object> serializer = getFastJsonSerialize();
        // 设置key序列化
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());

        // 设置value序列化
        redisTemplate.setValueSerializer(serializer);
        redisTemplate.setHashValueSerializer(serializer);

        return redisTemplate;
    }

    /**
     * Cache Manager配置
     */
    @Bean
    @Override
    public CacheManager cacheManager() {

        FastJsonRedisSerializer<Object> serializer = getFastJsonSerialize();

        RedisCacheConfiguration cacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .disableCachingNullValues()
                .entryTtl(Duration.ofMinutes(5L))
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(serializer));
//                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericFastJsonRedisSerializer()));


        return RedisCacheManager.builder(redisConnectionFactory)
                .cacheDefaults(cacheConfiguration)
                .build();

    }


    /**
     * 配置fastjson
     */
    private FastJsonRedisSerializer<Object> getFastJsonSerialize(){
        FastJsonRedisSerializer<Object> serializer = new FastJsonRedisSerializer<>(Object.class);
        FastJsonConfig fastJsonConfig = new FastJsonConfig();

        /**
         * fastJsonConfig.setReaderFeatures(JSONReader.Feature.SupportAutoType);
         * 安全起见限定类的包名，只有这个包名下才能序列化
         */
        fastJsonConfig.setReaderFilters(JSONReader.autoTypeFilter("org.hzz.redis"));
        /**
         * 为了支持自动类型转换，需要JSONWriter.Feature.WriteClassName序列化类的全名
         */
        fastJsonConfig.setWriterFeatures(JSONWriter.Feature.WriteClassName,JSONWriter.Feature.WriteMapNullValue, JSONWriter.Feature.PrettyFormat);
        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
        serializer.setFastJsonConfig(fastJsonConfig);
        return serializer;
    }
}
