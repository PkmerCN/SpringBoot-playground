package org.hzz.redis.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/7
 */
@Data
@Accessors(chain = true)
public class AddressDto {
    String city;
}
