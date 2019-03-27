package com.example.demo.designpattern.decorator;

//调料抽象类继承饮料类
public abstract class CondimentDecorator extends Beverage{
	public abstract String getDescription();
}
