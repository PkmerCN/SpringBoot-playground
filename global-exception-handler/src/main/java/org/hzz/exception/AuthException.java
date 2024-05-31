package org.hzz.exception;

/**
 * 认证异常
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/5/31
 */
public class AuthException extends RuntimeException{
    public AuthException(String message) {
        super(message);
    }
}
