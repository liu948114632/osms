package com.itecheasy.headfirst.observer.WeatherStation;

import java.util.*;

public class WeatherStation {

	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
	
		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);   //创建观察者
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);		//创建观察者
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);		//创建观察者

		forecastDisplay.removeObserver();	//移除命令是观察者自己决定的，而不是被观察者

		weatherData.setMeasurements(80, 65, 30.4f);
		weatherData.setMeasurements(82, 70, 29.2f);
		weatherData.setMeasurements(78, 90, 29.2f);
	}
}
