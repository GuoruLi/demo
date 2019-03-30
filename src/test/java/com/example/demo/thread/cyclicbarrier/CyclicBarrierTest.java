package com.example.demo.thread.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by Guoru on 2019/3/30.
 */
public class CyclicBarrierTest {
    static CyclicBarrier c = new CyclicBarrier(2);//必须有两个线程调用await时屏障才开启

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.await();//新线程进入屏障
                } catch (Exception e) {
                }
                System.out.println(1);
            }
        }).start();
        try {
            c.await();//主线程进入屏障
        } catch (Exception e) {
        }
        System.out.println(2);
    }
}
