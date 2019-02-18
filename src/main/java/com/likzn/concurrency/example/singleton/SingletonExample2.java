package com.likzn.concurrency.example.singleton;

import com.likzn.concurrency.annotation.ThreadSafe;

/**
 * @auther: Li jx
 * @date: 2019/2/16 16:22
 * @description: 饿汉模式, 在类加载时创建，只加载不使用会造成浪费
 */
@ThreadSafe
public class SingletonExample2 {

    //私有的构造函数
    private SingletonExample2() {

    }

    // 单例对象
    private static SingletonExample2 instance = new SingletonExample2();

    // 静态的工厂方法
    public static SingletonExample2 getInstance() {
        return instance;
    }
}
