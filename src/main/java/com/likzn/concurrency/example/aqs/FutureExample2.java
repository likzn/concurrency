package com.likzn.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @auther: Li jx
 * @date: 2019/3/5 15:58
 * @description:
 */
@Slf4j
public class FutureExample2 {

    static int a = 0;
    static final class Task implements Callable<Integer>{
        @Override
        public Integer call() throws Exception {
            log.info("{开始在Callable做事}");
            for (int i = 0; i < 10000; i++) {
                a++;
                a = a * a + 1;


            }
            return a;
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future future = executorService.submit(new Task());
        while (!future.isDone()){
            log.info("waiting");
            Thread.sleep(100);
        }
        log.info("{}", future.get());

    }
}
