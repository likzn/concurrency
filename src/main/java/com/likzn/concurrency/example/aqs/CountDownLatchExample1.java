package com.likzn.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @auther: Li jx
 * @date: 2019/2/22 15:13
 * @description:
 */
@Slf4j
public class CountDownLatchExample1 {
    private final static int THREAD_COUNT = 200;

    private static CountDownLatch countDownLatch = new CountDownLatch(THREAD_COUNT);

    private static ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < THREAD_COUNT; i++) {

            int currentThread = i;
            executor.execute(() -> {
                test(currentThread);
                countDownLatch.countDown();
            });
        }
        log.info("ok");
        executor.shutdown();
    }

    public static void test(int i) {
        log.info("{}", i);
    }
}
