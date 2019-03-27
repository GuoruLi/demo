package com.example.demo.lock;

import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {
	public static void main(String[] args) {
		LockSupport.park();//阻塞当前线程，除非unpark或者被中断
		LockSupport.unpark(Thread.currentThread());
	}
}
