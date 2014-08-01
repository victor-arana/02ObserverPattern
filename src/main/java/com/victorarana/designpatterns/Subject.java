package com.victorarana.designpatterns;

public interface Subject {
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	/**
	 * We tell all the observers about the state. Because they are 
	 * all they are all Observers, we know they all implement update(), 
	 * so we know how to notify them.
	 */
	public void notifyObservers();
}
