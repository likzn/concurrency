package com.likzn.concurrency.threadlocal;

/**
 * @auther: Li jx
 * @date: 2019/2/18 22:12
 * @description:
 */
public class Threadlocal {
    public final static ThreadLocal<Long> THREAD_LOCAL = new ThreadLocal();


    public static void set(long id) {
        THREAD_LOCAL.set(id);
    }

    public static Long get() {
        return THREAD_LOCAL.get();
    }

    public static void remove() {
        THREAD_LOCAL.remove();
    }
}
