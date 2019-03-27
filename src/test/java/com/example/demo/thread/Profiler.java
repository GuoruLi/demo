package com.example.demo.thread;

import java.util.concurrent.TimeUnit;

public class Profiler {
    // 第一次get()方法调用时会进行初始化（如果set方法没有调用），每个线程会调用一次
    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>() {
        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };

    public static final void begin() {
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    public static final long end() {
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) throws Exception {
//        Profiler.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Main start at : " + TIME_THREADLOCAL.get() + " mills");
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
//                Profiler.begin();
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T1 start at: " + TIME_THREADLOCAL.get() + " mills");
            }
        });
        t1.start();
    }
}