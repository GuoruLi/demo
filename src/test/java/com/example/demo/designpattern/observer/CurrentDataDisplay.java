package com.example.demo.designpattern.observer;

public class CurrentDataDisplay implements Observer{
	private Subject subject;
	
	public CurrentDataDisplay(Subject subject) {
		this.subject = subject;//观察者持有被观察者对象，以便取得最新数据
		this.subject.registerObserver(this);//注册到主题的列表中，以便数据更新后被通知
	}

	@Override
	public void update() {
		System.out.print("Current conditions : " + subject.getData());
	}

}
