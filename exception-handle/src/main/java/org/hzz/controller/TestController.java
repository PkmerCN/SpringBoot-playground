package org.hzz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/5/31
 */
@Controller
public class TestController {

    @GetMapping("/hello")
    public ModelAndView testview(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello"); // 逻辑视图名称
        modelAndView.addObject("message", "Hello, Spring Boot with ModelAndView!");
        return modelAndView;
    }
}
