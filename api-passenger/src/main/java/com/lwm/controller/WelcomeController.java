package com.lwm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author weeming
 * @date 2022/9/17 15:52
 */
@RestController
public class WelcomeController {

    @GetMapping("/welcome")
    public String welcome() {
        return "hello passenger, welcome to visit.";
    }

}
