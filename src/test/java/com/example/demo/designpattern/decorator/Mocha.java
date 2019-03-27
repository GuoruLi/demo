package com.example.demo.designpattern.decorator;

//摩卡装饰类，在被装饰者的动作之后加入自己的行为
public class Mocha extends CondimentDecorator{
	Beverage beverage;//装饰类持有原始组件的引用，以获得被装饰者的属性
	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}
	@Override
	public String getDescription() {
		return beverage.getDescription() + "+摩卡";
	}

	@Override
	public double cost() {
		return beverage.cost() + 2;
	}
}
