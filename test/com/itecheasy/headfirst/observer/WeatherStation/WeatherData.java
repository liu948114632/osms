package com.itecheasy.headfirst.observer.WeatherStation;

import java.util.*;


public class WeatherData implements Subject {
	private ArrayList observers = new ArrayList();
	private float temperature;
	private float humidity;
	private float pressure;
	
	public WeatherData() {
//		observers = new ArrayList();
	}
	
	public void registerObserver(Observer o) {
		observers.add(o);
	}
	
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}
	}
	
	public void notifyObservers() {
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = (Observer)observers.get(i);
			observer.update(temperature, humidity, pressure);
		}
	}
	
//	public void measurementsChanged() {
//		notifyObservers();
//	}
	
	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;	//被观察者一旦改变就立刻通知观察者
		this.humidity = humidity;
		this.pressure = pressure;
//		measurementsChanged();   //在set方法中增加更新的方法
		notifyObservers();
	}
	
	// other WeatherData methods here
	
	public float getTemperature() {
		return temperature;
	}

	public float getHumidity() {
		return humidity;
	}

	public float getPressure() {
		return pressure;
	}
}
