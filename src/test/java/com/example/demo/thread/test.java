package com.example.demo.thread;

/**
 * Created by Guoru on 2019/3/19.
 */
public class test {
    public static void main(String[] args) {
        Thread sleepThread = new Thread(new SleepRunner(), "SleepThread");
        sleepThread.setDaemon(true);
// busyThread不停的运行
        Thread busyThread = new Thread(new BusyRunner(), "BusyThread");
        busyThread.setDaemon(true);
        sleepThread.start();
        busyThread.start();
// 休眠5秒，让sleepThread和busyThread充分运行
        SleepUtils.second(5);
        sleepThread.interrupt();
        busyThread.interrupt();
        System.out.println("SleepThread interrupted is " + sleepThread.isInterrupted());
        System.out.println("BusyThread interrupted is " + busyThread.isInterrupted());
// 防止sleepThread和busyThread立刻退出
        SleepUtils.second(2);
    }

    static class SleepRunner implements Runnable {
        @Override
        public void run() {
            while (true) {
                SleepUtils.second(10);
            }
        }
    }

    static class BusyRunner implements Runnable {
        @Override
        public void run() {
            while (true) {
            }
        }
    }

    static class SleepUtils{
        public static void second(int time){
            try{
                Thread.currentThread().sleep(time);
            }catch (InterruptedException e){
                System.out.print("中断异常\n");
            }
        }
    }
}
