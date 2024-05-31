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

    // 抛出异常
    @RequestMapping("/exception")
    public void testException(){
        int a = 1/0;
    }

    // 抛出异常
    @RequestMapping("throws-exception")
    public void throwExcep(){
        throw new RuntimeException("My Runtime Exception");
    }

    /**
     * 处理本Controller抛出的异常，如果请求Accept包含text/html,我们就直接交给BasicErrorController处理，让他返回模板的error.html
     * （具体原理：spring会将没有处理的异常通过内部forward到/error,在BasicErrorController中会使用errorHtml方法返回一个ModelAndView）
     * 然后我们使用Thymeleaf模板引擎来渲染数据。
     *
     * 其他Accept的直接统一处理为JSON数据返回。
     * @throws Exception
     */
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
