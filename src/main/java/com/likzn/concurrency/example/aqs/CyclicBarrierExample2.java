package com.likzn.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @auther: Li jx
 * @date: 2019/3/5 12:43
 * @description:
 */
@Slf4j
public class CyclicBarrierExample2 {

    final static ExecutorService executor = Executors.newCachedThreadPool();
    final static CyclicBarrier CYCLIC_BARRIER = new CyclicBarrier(5);

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
        //及时清理线程池
        executor.shutdown();

    }

    public static void race(int threadNum) throws Exception{
        log.info("Current Thread,{}", threadNum);
        //程序若想继续执行，必须捕捉异常
        CYCLIC_BARRIER.await(2000, TimeUnit.MILLISECONDS);
        log.info("continue,{}", threadNum);
    }

}
