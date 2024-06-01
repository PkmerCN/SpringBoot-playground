package org.hzz.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/2
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String cellPhone;
    private String password;
}
