package com.likzn.concurrency.example.singleton;

import com.likzn.concurrency.annotation.NotThreadSafe;

/**
 * @auther: Li jx
 * @date: 2019/2/16 16:22
 * @description: 懒汉模式, 在第一次使用时创建实例，使用双重同步锁
 */
@NotThreadSafe
public class SingletonExample4 {

    //私有的构造函数
    private SingletonExample4() {

    }
    //1 memory = allocate()
    //2 ctorInstance()
    //3 instance = memory 使创建的对象指向内存

    // JVM和cpu优化，发生了指令重排

    // 1、memory = allocate() 分配对象的内存空间
    // 3、instance = memory 设置instance指向刚分配的内存
    // 2、ctorInstance() 初始化对象


    // 单例对象
    private static SingletonExample4 instance = null;

    // 静态的工厂方法
    public static SingletonExample4 getInstance() {
        if (null == instance) {//双重同步锁  //b
            synchronized (SingletonExample4.class) { //同步锁
                if (null == instance) {
                    instance = new SingletonExample4(); // A - 3
                }
            }
        }
        return instance;
    }
}
