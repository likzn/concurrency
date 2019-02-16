package com.likzn.concurrency.example.publish;

import com.likzn.concurrency.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @auther: Li jx
 * @date: 2019/2/16 14:20
 * @description:
 */
@Slf4j
@NotThreadSafe
public class Publish {
    /*
    一个对象的内部变量被其他范围使用
     */

    private String[] strings = {"a", "b", "c"};

    public String[] getStrings() {
        return strings;
    }

    public static void main(String[] args) {
        Publish publish = new Publish();
        System.out.println(Arrays.toString(publish.getStrings()));
        publish.strings[0] = "2";
        System.out.println(Arrays.toString(publish.getStrings()));

    }
}
