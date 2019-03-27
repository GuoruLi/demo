package com.example.demo.designpattern.single;

public class Singleton {
	/*private static Singleton singleton = new Singleton();//饿汉式
	private Singleton(){}
	public static Singleton getInstance(){
		return singleton;
	}*/
	private static volatile Singleton singleton = null;
	private Singleton(){}
	public static Singleton getInstance(){
		if(null == singleton){
			synchronized(Singleton.class){
				if(null == singleton){
					singleton = new Singleton();//这里需要双重检测，避免多个线程同时进入第一个if
				}
			}
		}
		return singleton;
	}
}
