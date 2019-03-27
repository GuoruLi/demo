package com.example.demo.designpattern.observer;

/**
 * 被观察者抽象类
 * @author Ruby
 *
 */
public interface Subject {
	public void registerObserver(Observer observer);//注册
	public void removeObserver(Observer observer);//移除
	public void notifyObservers();//通知
	public String getData();//提供获取数据接口
}
