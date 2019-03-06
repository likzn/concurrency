package com.likzn.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @auther: Li jx
 * @date: 2019/3/5 12:43
 * @description:
 */
@Slf4j
public class CyclicBarrierExample3 {

    final static ExecutorService executor = Executors.newCachedThreadPool();
    //线程达到屏障后，首先执行runnable
    final static CyclicBarrier CYCLIC_BARRIER = new CyclicBarrier(5, () -> {
        log.info("第一执行");
    });

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            final int threadNum = i;
            Thread.sleep(1000);
            executor.execute(()->{
                try {
                    race(threadNum);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            });

        }
        executor.shutdown();

    }

    public static void race(int threadNum) throws Exception{
        log.info("Current Thread,{}", threadNum);
        CYCLIC_BARRIER.await();
        log.info("continue,{}", threadNum);
    }

}
