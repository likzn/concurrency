package com.likzn.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @auther: Li jx
 * @date: 2019/3/5 15:58
 * @description:
 */
@Slf4j
public class FutureExample1 {


    static final class Task implements Callable<String>{
        @Override
        public String call() throws Exception {
            log.info("{开始在Callable做事}");
            Thread.sleep(4000);
            return "Done";
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future future = executorService.submit(new Task());
        log.info("Do something in main");
        Thread.sleep(1000);
        log.info("{}", future.get());
        executorService.shutdown();

    }
}
