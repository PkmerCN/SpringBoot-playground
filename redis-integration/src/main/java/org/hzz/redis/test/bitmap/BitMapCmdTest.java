package org.hzz.redis.test.bitmap;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.connection.BitFieldSubCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/28
 */
@Component
public class BitMapCmdTest implements CommandLineRunner {

    @Setter(onMethod_ = @Autowired)
    private StringRedisTemplate redisTemplate;

    @Override
    public void run(String... args) throws Exception {
        getBitField();
    }

    /**
     * 通过redis: bitfield hzz get u32 0
     */
    public void getBitField(){
        List<Long> bitFieldResult = redisTemplate.opsForValue().bitField("hzz",
                BitFieldSubCommands.create()
                        .get(BitFieldSubCommands.BitFieldType.unsigned(5)).valueAt(0));

        if (bitFieldResult != null && !bitFieldResult.isEmpty()) {
            long bitValue = bitFieldResult.get(0);
            String binaryRepresentation = String.format("%8s", Long.toBinaryString(bitValue)).trim();
            System.out.println(binaryRepresentation);
        }

        //输出的目标值： 11100101 00000000 00000000 00000100
        //redis实际值： 11100101 00000000 00000000 00000100

    }

    /**
     * get key
     * 用string输出的值不对
     */
    public void getValue(){
        String value = redisTemplate.opsForValue().get("hzz");
        // 将字符串值转换为二进制表示
        StringBuilder binaryRepresentation = new StringBuilder();
        for (char c : value.toCharArray()) {
            binaryRepresentation.append(String.format("%8s", Integer.toBinaryString(c)).replace(' ', '0'));
        }
        // 11111111 11111101 00000000 00000000 00000100
        //          11100101 00000000 00000000 00000100
        System.out.println(binaryRepresentation);
    }
}


