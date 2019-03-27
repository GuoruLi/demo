package com.example.demo.thread;

import java.util.concurrent.Semaphore;

public class PrintABCUsingSemaphore {
	   private int times;
	   private Semaphore semaphoreA = new Semaphore(1);
	   private Semaphore semaphoreB = new Semaphore(0);
	   private Semaphore semaphoreC = new Semaphore(0);

	   public PrintABCUsingSemaphore(int times) {
	       this.times = times;
	   }

	   public static void main(String[] args) {
	       PrintABCUsingSemaphore printABC = new PrintABCUsingSemaphore(10);

	       // 非静态方法引用  x::toString   和() -> x.toString() 是等价的！
	       new Thread(printABC::printA).start();
	       new Thread(printABC::printB).start();
	       new Thread(printABC::printC).start();

	       /*new Thread(() -> printABC.printA()).start();
	       new Thread(() -> printABC.printB()).start();
	       new Thread(() -> printABC.printC()).start();
	*/
	   }

	   public void printA() {
	       try {
	           print("A", semaphoreA, semaphoreB);
	       } catch (InterruptedException e) {
	           e.printStackTrace();
	       }
	   }

	   public void printB() {
	       try {
	           print("B", semaphoreB, semaphoreC);
	       } catch (InterruptedException e) {
	           e.printStackTrace();
	       }
	   }

	   public void printC() {
	       try {
	           print("C", semaphoreC, semaphoreA);
	       } catch (InterruptedException e) {
	           e.printStackTrace();
	       }
	   }

	   private void print(String name, Semaphore current, Semaphore next)
	           throws InterruptedException {
	       for (int i = 0; i < times; i++) {
	           current.acquire();//获得信号量许可，并将许可数量减一变为0，再次进入时该线程将会被阻塞
	           System.out.print(name);
	           next.release();//释放许可，返回一个许可到next信号量上
	       }
	   }
	}