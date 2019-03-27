package com.example.demo.designpattern.observer;

public class TestMain {
	public static void main(String[] args){
		WeatherData weatherData = new WeatherData();
		CurrentDataDisplay observer = new CurrentDataDisplay(weatherData);
		weatherData.setData("hello world!");
		weatherData.removeObserver(observer);
		weatherData.setData("hello world again!");
	}
}
