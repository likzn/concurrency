package com.likzn.concurrency.example.publish;

import com.likzn.concurrency.annotation.NotRecommend;
import com.likzn.concurrency.annotation.NotThreadSafe;

/**
 * @auther: Li jx
 * @date: 2019/2/16 14:25
 * @description:
 */
@NotThreadSafe
@NotRecommend
public class Escape {
    /*
    对象还未构建完成，就被其他线程所见
     */

    private int a = 0;

    public Escape() {
        new innerClass();
    }

    public class innerClass {

        public innerClass() {
            System.out.println(Escape.this.a);
        }

    }

    public static void main(String[] args) {
        new Escape();
    }

}
