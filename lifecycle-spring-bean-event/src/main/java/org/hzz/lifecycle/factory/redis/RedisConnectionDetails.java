package org.hzz.lifecycle.factory.redis;

import org.hzz.lifecycle.factory.ConnectionDetails;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/9
 */
public class RedisConnectionDetails implements ConnectionDetails {
    @Override
    public String toString() {
        return "我是RedisConnectionDetails";
    }
}
