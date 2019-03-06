package com.likzn.concurrency.example.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @auther: Li jx
 * @date: 2019/3/6 13:22
 * @description:
 */
@Slf4j
public class TreadPoolExample2 {


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
                final int a = i;
            executorService.execute(()->{
                log.info("Task,{}",a);
            });
        }
    }
}
