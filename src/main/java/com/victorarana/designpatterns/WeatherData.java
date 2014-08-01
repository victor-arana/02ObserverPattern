package com.victorarana.designpatterns;

import java.util.ArrayList;

public class WeatherData implements Subject {

	private ArrayList<Observer> observers;
	private float temperature;
	private float humidity;
	private float pressure;
	
	public WeatherData() {
		observers = new ArrayList<Observer>();
	}

	@Override
	public void registerObserver(Observer o) {
		// When an observer registers, we just add it to the end
		// of the list
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if( i >= 0 ){
			observers.remove(i);
		}
	}

	/* 
	 * We tell all the observers about the state. Because they are 
	 * all they are all Observers, we know they all implement update(), 
	 * so we know how to notify them.
	 * @see com.victorarana.designpatterns.Subject#notifyObservers()
	 */
	@Override
	public void notifyObservers() {
		for(int i = 0; i < observers.size(); i++){
			Observer observer = (Observer) observers.get(i);
			observer.update(temperature, humidity, pressure);			
		}
	}
	
	/**
	 * We notify the Observers when we get updated measurements from the 
	 * Weather station
	 */
	public void measurementsChanged(){
		notifyObservers();
	}
	
	public void setMeasurements(float temperature, float humidity, float pressure){
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}
	
}
