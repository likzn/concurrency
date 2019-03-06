package com.likzn.concurrency.example.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @auther: Li jx
 * @date: 2019/3/6 13:22
 * @description:
 */
@Slf4j
public class TreadPoolExample4 {


    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
       executorService.scheduleAtFixedRate(() -> {
            log.info("hello");
        },1,3,TimeUnit.SECONDS);
    }
}
