package org.hzz.redis.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 测试支持的类型
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/7
 */
@Data
@Accessors(chain = true)
public class UserDto {
    String name;
    Integer days;
    Boolean javaDeveloper;
    LocalDateTime createTime;
    AddressDto address;
}
