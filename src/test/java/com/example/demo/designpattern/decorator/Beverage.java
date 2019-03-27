package com.example.demo.designpattern.decorator;

//基础组件  饮料类
public abstract class Beverage {
	String description = "unknown";

	public String getDescription() {
		return description;
	}
	
	public abstract double cost();
}
