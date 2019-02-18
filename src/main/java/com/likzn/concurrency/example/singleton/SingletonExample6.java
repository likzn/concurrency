package com.likzn.concurrency.example.singleton;

import com.likzn.concurrency.annotation.ThreadSafe;

/**
 * @auther: Li jx
 * @date: 2019/2/16 16:22
 * @description: 饿汉模式, 在类加载时创建
 */
@ThreadSafe
public class SingletonExample6 {

    //私有的构造函数
    private SingletonExample6() {

    }

    // 单例对象 注意顺序，先是创建对象后是静态代码块，否则会空
    private static SingletonExample6 instance = null;

    static {
        instance = new SingletonExample6();
    }

    // 静态的工厂方法
    public static SingletonExample6 getInstance() {
        return instance;
    }
}
