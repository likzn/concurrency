package com.likzn.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @auther: Li jx
 * @date: 2019/3/5 15:58
 * @description:
 */
@Slf4j
public class FutureTaskExample2 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.info("{开始在Callable做事}");
                Thread.sleep(4000);
                return "Done";
            }
        });
        new Thread(futureTask).start();

        log.info("Do something in main");
        Thread.sleep(1000);
        log.info("{}", futureTask.get());

    }
}
