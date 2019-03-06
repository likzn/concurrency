package com.likzn.concurrency.example.lock;

import com.likzn.concurrency.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @auther: Li jx
 * @date: 2019/2/15 19:18
 * @description:
 */
@Slf4j
@ThreadSafe
public class LockExample1 {
    //请求总数
    final static int CLINET_TOTAL = 2000;
    //并发总数
    final static int THREAD_TOTAL = 50;

    synchronized static void add() {
        count++;
    }
    static int count = 0;
    public static void main(String[] args) throws Exception {
        //计数器闭锁，await（）后等待所有线程，完成一个countdown一个
        CountDownLatch countDownLatch = new CountDownLatch(CLINET_TOTAL);
        //信号量，可以控制并发数
        Semaphore semaphore = new Semaphore(THREAD_TOTAL);

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < CLINET_TOTAL; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("{}", count);
    }
}
