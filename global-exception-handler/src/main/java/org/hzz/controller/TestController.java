package org.hzz.controller;

import lombok.extern.slf4j.Slf4j;
import org.hzz.exception.AuthException;
import org.hzz.exception.ErrorMsg;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/5/31
 */
@Slf4j
@RestController
public class TestController {

    @GetMapping("/test1")
    public void test1(){
        log.info("call test1");
        int i = 1 / 0;
    }

    @GetMapping("test2")
    public void test2(){
        log.info("call test2");
    }

    //@ExceptionHandler({RuntimeException.class})
    public ResponseEntity<Map<String,Object>> handlerMathException(){
        log.info("local exception handled");
        Map<String,Object> body = Map.of("message","除以0");
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    //@ExceptionHandler({AuthException.class})
    public ResponseEntity<ErrorMsg> handleAuthException(Exception e){
        log.info("local auth exception handled");
        ErrorMsg body = ErrorMsg.builder()
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message("没有登录")
                .timestamp(new Date())
                .description(e.getMessage())
                .build();
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
