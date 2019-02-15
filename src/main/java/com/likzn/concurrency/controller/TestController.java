package com.likzn.concurrency.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther: Li jx
 * @date: 2019/2/15 12:18
 * @description:
 */
@RestController
public class TestController {
    @GetMapping("/test")
    public String test() {
        return "sss";
    }

}
