package com.itecheasy.headfirst.observer.WeatherStation;

import java.util.*;


public class ForecastDisplay implements Observer, DisplayElement {
	private float currentPressure = 29.92f;  
	private float lastPressure;
	private WeatherData weatherData;

	public ForecastDisplay(WeatherData weatherData) {	//this 指当前的这个对象
		this.weatherData = weatherData; //初始化weatherData	并且记录下来
		weatherData.registerObserver(this); //this 反向调用传入的对象的方法，把自己给放入
	}

	public void removeObserver() {
		this.weatherData.removeObserver(this);
	}


	public void update(float temp, float humidity, float pressure) {
		lastPressure = currentPressure;
		currentPressure = pressure;

		display();
	}

	public void display() {
		System.out.print("Forecast: ");
		if (currentPressure > lastPressure) {
			System.out.println("Improving weather on the way!");	//明天是个好天气
		} else if (currentPressure == lastPressure) {
			System.out.println("More of the same");			//老样子
		} else if (currentPressure < lastPressure) {
			System.out.println("Watch out for cooler, rainy weather");	//watch 小心
		}
	}
}
