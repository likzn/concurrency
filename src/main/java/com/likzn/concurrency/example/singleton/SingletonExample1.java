package com.likzn.concurrency.example.singleton;

import com.likzn.concurrency.annotation.NotThreadSafe;

/**
 * @auther: Li jx
 * @date: 2019/2/16 16:22
 * @description: 懒汉模式, 在第一次使用时创建实例
 */
@NotThreadSafe //多线程时可能会多次调用构造函数，若构造器有加载，会重复加载
public class SingletonExample1 {

    //私有的构造函数
    private SingletonExample1() {

    }

    // 单例对象
    private static SingletonExample1 instance = null;

    // 静态的工厂方法
    public static SingletonExample1 getInstance() {

        if (null == instance) {
            instance = new SingletonExample1();
        }
        return instance;
    }
}
