package org.hzz.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/5/31
 */
@Slf4j
@Controller
public class TestController {

    @GetMapping("/hello")
    public ModelAndView testview(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello"); // 逻辑视图名称
        modelAndView.addObject("message", "Hello, Spring Boot with ModelAndView!");
        return modelAndView;
    }

    @RequestMapping("/exception")
    public void testException(){
        int a = 1/0;
    }

    @RequestMapping("throws-exception")
    public void throwExcep(){
        throw new RuntimeException("My Runtime Exception");
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<Map<String, Object>> handleException(HttpServletRequest request,Exception e) throws Exception {
        String accept = request.getHeader("Accept");
        log.info("Accept: {}",request.getHeader("Accept"));
        log.info("检查到异常 {}",e.getMessage());
        // 如果是浏览器请求，我们直接抛出异常，交给BasicErrorController处理
        if(accept != null && accept.contains("text/html")){
            throw e;
        }
        // 否则返回JSON异常信息
        Map<String,Object> body = Map.of("message",e.getMessage(),"details",e);
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
