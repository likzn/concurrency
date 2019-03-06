package com.likzn.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @auther: Li jx
 * @date: 2019/2/22 15:13
 * @description:
 */
@Slf4j
public class SemaphoreExample2 {
    private final static int THREAD_COUNT = 20;

    private static CountDownLatch countDownLatch = new CountDownLatch(THREAD_COUNT);

    final static Semaphore semaphore = new Semaphore(3);

    private static ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < THREAD_COUNT; i++) {
            int currentThread = i;
            executor.execute(() -> {
                try {
                    //一次性获得多个许可
                    if (semaphore.tryAcquire(3)) {
                        test(currentThread);
                        semaphore.release(3);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        executor.shutdown();
    }
    public static void test(int i) throws Exception {
        Thread.sleep(1000);

        log.info("{}", i);
    }
}
