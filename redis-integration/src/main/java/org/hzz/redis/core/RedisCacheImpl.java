package org.hzz.redis.core;

import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * RedisTemplate封装
 * 使用FastJson
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/7
 */
@SuppressWarnings(value = {"unchecked", "rawtypes"})
@Component
@Slf4j
public class RedisCacheImpl implements RedisCache{
    private final RedisTemplate redisTemplate;

    public RedisCacheImpl(@Qualifier("redisTemplate") RedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> void setObject(String key, T value) {
        log.info("插入字符串: {}",value.toString());
        ValueOperations<String, T> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key,value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> void setObject(String key, T value, Long timeout, TimeUnit timeUnit) {
        ValueOperations<String, T> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key,value,timeout,timeUnit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> void setObject(String key, T value, Long timeout) {
        ValueOperations<String, T> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key,value,timeout,TimeUnit.SECONDS);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T getObject(String key,Class<T> clazz) {
        log.info("根据 key = {} 获取",key);
        Object o = redisTemplate.opsForValue().get(key);
        if(o instanceof JSONObject jsonObject){
            return jsonObject.to(clazz);
        }
        throw new RuntimeException("fastjson转化失败");
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean deleteObject(String key) {
        log.info("删除缓存 key = {}",key);
        return redisTemplate.delete(key);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public long deleteObject(Collection<?> keys) {
        return redisTemplate.delete(keys);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean expire(String key, long timeout) {
        return redisTemplate.expire(key,timeout,TimeUnit.SECONDS);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean expire(String key, long timeout, TimeUnit unit) {
        return redisTemplate.expire(key,timeout,unit);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public <T> long setList(String key, List<T> dataList) {
        log.info("插入List 元素{}个",dataList.size());
        ListOperations<String,T> listOperations = redisTemplate.opsForList();
        Long r = listOperations.leftPushAll(key,dataList);
        return r == null ? 0: r;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> List<T> getList(String key) {
        log.info("获取List");
        ListOperations<String,T> listOperations = redisTemplate.opsForList();
        List<T> lists = listOperations.range(key, 0, -1);
        return lists == null ? Collections.<T>emptyList() : lists;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public <T> long setSet(String key, Set<T> dataSet) {
        log.info("设置set");
        SetOperations<String,T> setOperations = redisTemplate.opsForSet();
        T[] array = (T[])dataSet.toArray(new Object[0]);
        Long r = setOperations.add(key,array);
        return r == null ? 0:r;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public <T> Set<T> getCacheSet(String key) {
        SetOperations<String,T> setOperations = redisTemplate.opsForSet();
        Set<T> members = setOperations.members(key);
        return members == null ? Collections.<T>emptySet() : members;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public <T> void setMap(String key, Map<String, T> dataMap) {
        log.info("插入hash");
        HashOperations<String,String,T> hashOperations = redisTemplate.opsForHash();
        hashOperations.putAll(key,dataMap);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public <T> Map<String, T> getMap(String key) {
        HashOperations<String,String,T> hashOperations = redisTemplate.opsForHash();
        Map<String, T> entries = hashOperations.entries(key);
        return entries == null ? Collections.<String,T>emptyMap() : entries;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public <T> void setMapValue(String key, String hKey, T value) {
        log.info("设置hash key = {} hashKey = {}",key,hKey);
        HashOperations<String,String,T> hashOperations = redisTemplate.opsForHash();
        hashOperations.put(key,hKey,value);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T getMapValue(String key, String hKey) {
        HashOperations<String,String,T> hashOperations = redisTemplate.opsForHash();
        return hashOperations.get(key, hKey);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Long delMapValue(String key, String hkey) {
        Long r = redisTemplate.opsForHash().delete(key, hkey);
        return r == null ? 0 : r;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public <T> List<T> getMultiCacheMapValue(String key, Collection<String> hKeys) {
        HashOperations<String,String,T> hashOperations = redisTemplate.opsForHash();
        List<T> ts = hashOperations.multiGet(key, hKeys);
        return ts == null ? Collections.<T>emptyList() : ts;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<String> keys(String pattern) {
        return redisTemplate.keys(pattern);
    }

}
