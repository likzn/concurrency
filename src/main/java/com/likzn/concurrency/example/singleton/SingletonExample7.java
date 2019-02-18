package com.likzn.concurrency.example.singleton;

import com.likzn.concurrency.annotation.Recommend;
import com.likzn.concurrency.annotation.ThreadSafe;

/**
 * @auther: Li jx
 * @date: 2019/2/16 16:22
 * @description: 枚举模式，最安全
 */
@ThreadSafe
@Recommend
public class SingletonExample7 {

    //私有的构造函数
    private SingletonExample7() {

    }

    public static SingletonExample7 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
        INSTANCE,
        ;

        private SingletonExample7 singletonExample7 = null;

        Singleton() {
            singletonExample7 = new SingletonExample7();
        }

        public SingletonExample7 getInstance() {
            return singletonExample7;
        }

    }
}
