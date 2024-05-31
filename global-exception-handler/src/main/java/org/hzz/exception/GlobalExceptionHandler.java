package org.hzz.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.Map;

/**
 * 异常处理，两步骤
 * 1. 抓异常
 * 2. 统一异常的处理格式
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/5/31
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 返回值ResponseEntity会有一个转杯的处理这个返回值得returnvaluehandler
     * 会直接写入reponse以json的格式，所以我们不需要@RestControllerAdvice,或者@ResponseBody
     * @return ResponseEntity
     */
    @ExceptionHandler({ArithmeticException.class})
    public ResponseEntity<ErrorMsg> handlerMathException(Exception e){
        log.info("global math exception handled");
        ErrorMsg body = ErrorMsg.builder()
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message("不能除以0")
                .timestamp(new Date())
                .description(e.getMessage())
                .build();
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler({AuthException.class})
    public ResponseEntity<ErrorMsg> handleAuthException(Exception e){
        log.info("global auth exception handled");
        ErrorMsg body = ErrorMsg.builder()
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message("没有登录")
                .timestamp(new Date())
                .description(e.getMessage())
                .build();
        return new ResponseEntity<>(body, HttpStatus.OK);
    }
}
