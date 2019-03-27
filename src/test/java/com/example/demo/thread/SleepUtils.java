package com.example.demo.thread;

class SleepUtils{
        public static void second(int time){
            try{
                Thread.currentThread().sleep(time);
            }catch (InterruptedException e){
                System.out.print("中断异常\n");
            }
        }
    }