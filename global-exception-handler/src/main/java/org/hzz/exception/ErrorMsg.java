package org.hzz.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/5/31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorMsg {
    private int statusCode;
    private Date timestamp;
    private String message;
    private String description;
}
