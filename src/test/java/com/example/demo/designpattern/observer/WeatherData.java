package com.example.demo.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 被观察者具体类
 * @author Ruby
 *
 */
public class WeatherData implements Subject{
	private List<Observer> observerList = new ArrayList<Observer>();
	
	private String data = "";

	@Override
	public void registerObserver(Observer observer) {
		observerList.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observerList.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for(Observer observer : observerList){
			observer.update();
		}
	}
	
	public void setData(String data){
		this.data = data;
		notifyObservers();
		/**
		 * 不使用观察者时，属于面向实现编程，增加或删除布告板时都需要修改这块代码
		 * new CurrentDataDisplay().update(data);
		 */
	}

	public String getData() {
		return data;
	}

}
