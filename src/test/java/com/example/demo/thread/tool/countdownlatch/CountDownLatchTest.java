package com.example.demo.thread.tool.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Guoru on 2019/3/30.
 */
public class CountDownLatchTest {
    static CountDownLatch c = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                c.countDown();
                System.out.println(2);
                c.countDown();
            }
        }).start();
        c.await();//主线程阻塞直到latch被countDown为0，和join的效果相同
        System.out.println("3");
    }
}
