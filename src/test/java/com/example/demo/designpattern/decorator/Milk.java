package com.example.demo.designpattern.decorator;

//牛奶装饰类
public class Milk extends CondimentDecorator{
	Beverage beverage;
	
	public Milk(Beverage beverage){
		this.beverage = beverage;
	}
	@Override
	public String getDescription() {
		return beverage.getDescription() + "+牛奶";
	}

	@Override
	public double cost() {
		return beverage.cost() + 1;
	}

}
