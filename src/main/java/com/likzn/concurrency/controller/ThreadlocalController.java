package com.likzn.concurrency.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.likzn.concurrency.threadlocal.Threadlocal.THREAD_LOCAL;


/**
 * @auther: Li jx
 * @date: 2019/2/18 22:29
 * @description:
 */
@RestController
@RequestMapping("/threadlocal")
public class ThreadlocalController {

    @RequestMapping("/user")
    public String te() {
        return THREAD_LOCAL.get().toString();
    }
}
