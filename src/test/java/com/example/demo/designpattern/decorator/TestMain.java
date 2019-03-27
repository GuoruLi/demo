package com.example.demo.designpattern.decorator;

public class TestMain {
	public static void main(String[] args){
		Beverage beverage = new Espresso();
		beverage = new Mocha(beverage);
		beverage = new Milk(beverage);
		beverage = new Milk(beverage);//可以多重修饰
		System.out.print(beverage.getDescription() + "$" + beverage.cost());
	}
}
