package org.hzz.lifecycle.factory.redis;

import org.hzz.lifecycle.factory.MyFactory;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/9
 */
public class RedisConnectionDetailsFactory implements MyFactory<RedisConnectionDetails> {
    @Override
    public RedisConnectionDetails getConectionDetails() {
        return new RedisConnectionDetails();
    }
}
