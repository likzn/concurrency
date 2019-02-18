package com.likzn.concurrency.example.singleton;

import com.likzn.concurrency.annotation.NotRecommend;
import com.likzn.concurrency.annotation.ThreadSafe;

/**
 * @auther: Li jx
 * @date: 2019/2/16 16:22
 * @description: 懒汉模式, 在第一次使用时创建实例
 */
@ThreadSafe
@NotRecommend
public class SingletonExample3 {

    //私有的构造函数
    private SingletonExample3() {

    }

    // 单例对象
    private static SingletonExample3 instance = null;

    // 静态的工厂方法,资源开销过大
    public synchronized static SingletonExample3 getInstance() {

        if (null == instance) {
            instance = new SingletonExample3();
        }
        return instance;
    }
}
