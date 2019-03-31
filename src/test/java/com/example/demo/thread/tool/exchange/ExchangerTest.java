package com.example.demo.thread.tool.exchange;

import java.util.concurrent.*;

/**
 * Created by Ruby on 2019/3/31.
 */
public class ExchangerTest {
    private static final Exchanger<String> exgr = new Exchanger<String>();//提供一个同步点，在这个同步点，两个线程可以交换彼此的数据
    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);
//    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2));

    public static void main(String[] args) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String A = "银行流水A";// A录入银行流水数据
                    String B = exgr.exchange(A);//如果A先执行，那么必须等待有一个线程也调用exchange，双方才会交换，否则该线程阻塞在这里
                    System.out.print("A 获取到 B的数据是："+ B + "\n");
                } catch (InterruptedException e) {
                }
            }
        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String B = "银行流水B";// B录入银行流水数据
                    String A = exgr.exchange(B);
                    System.out.println("A和B数据是否一致：" + A.equals(B) + "，A录入的是："
                            + A + "，B录入是：" + B+ "\n");
                } catch (InterruptedException e) {
                }
            }
        });
        threadPool.shutdown();
    }
}
