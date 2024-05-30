package org.hzz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/5/30
 */
@RestController
public class AppController {
    @GetMapping("/test")
    public String test(){
        return "Just Test";
    }

    @GetMapping("/header/test")
    public String headerTest(){
        return "for header";
    }
}
