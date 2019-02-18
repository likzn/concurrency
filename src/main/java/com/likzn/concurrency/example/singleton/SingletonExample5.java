package com.likzn.concurrency.example.singleton;

import com.likzn.concurrency.annotation.ThreadSafe;

/**
 * @auther: Li jx
 * @date: 2019/2/16 16:22
 * @description: 懒汉模式, 在第一次使用时创建实例，使用双重同步锁
 */
@ThreadSafe
public class SingletonExample5 {

    //私有的构造函数
    private SingletonExample5() {

    }
    //1 memory = allocate()
    //2 ctorInstance()
    //3 instance = memory 使创建的对象指向内存


    // 单例对象  volatile + 双重检测机制 -》 禁止指令重排
    private static volatile SingletonExample5 instance = null;

    // 静态的工厂方法
    public static SingletonExample5 getInstance() {
        if (null == instance) {//双重同步锁  //b
            synchronized (SingletonExample5.class) { //同步锁
                if (null == instance) {
                    instance = new SingletonExample5(); // A - 3
                }
            }
        }
        return instance;
    }
}
