package com.example.demo.lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExam {
	/**
     *     true 表示 ReentrantLock 的公平锁
     */
    private  ReentrantLock lock = new ReentrantLock(false);
    
    public static void main(String[] args){
    	final ReentrantLockExam reentrantLockExam = new ReentrantLockExam();
    	Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + "启动");
				reentrantLockExam.testLock();
			}
		};
		Thread[] threadArray = new Thread[10];
        for (int i=0; i<10; i++) {
            threadArray[i] = new Thread(runnable);
        }
        for (int i=0; i<10; i++) {
            threadArray[i].start();
        }
    }
    
    private void testLock(){
    	try{
    		lock.lock();
    		System.out.println(Thread.currentThread().getName() + "获得锁");
    	}finally{
    		lock.unlock();
    	}
    	
    }
}
