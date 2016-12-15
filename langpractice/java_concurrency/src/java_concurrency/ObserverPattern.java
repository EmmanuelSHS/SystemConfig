package java_concurrency;

import java.util.ArrayList;

interface Subject {
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObserver();
}

interface Observer {
	// use a changed function and flag could 
	// control the precision / frequency of update
	public void update(int temp, int pres, int humi);
}

interface Display {
	public void display();
}

class WeatherData implements Subject {
	private int temp;
	private int pres;
	private int humi;
	private ArrayList<Observer> observers;
	
	WeatherData() {
		temp = 0;
		pres = 0;
		humi = 0;
		observers = new ArrayList<Observer>();
	}
	
	public void registerObserver(Observer o) {
		observers.add(o);
	}
	
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if (i >= 0) 
			observers.remove(o);
	}
	
	//
	public void notifyObserver() {
		for (int i = 0; i < observers.size(); ++i) {
			Observer o = (Observer) observers.get(i);
			o.update(temp, pres, humi);
		}
	}
	
	public void measurementsChanged() {
		notifyObserver();
	}
	
	public void setMeasurements(int temp, int pres, int humi) {
		this.temp = temp;
		this.pres = pres;
		this.humi = humi;
		measurementsChanged();
	}
	
	public int getTemp() {
		return this.temp;
	}
	
	public int getPres() {
		return this.pres;
	}
	
	public int getHumi() {
		return this.humi;
	}
}

class CurrentConditionDisplayer implements Observer, Display {
	int temp;
	int pres;
	int humi;
	Subject data;
	
	CurrentConditionDisplayer(WeatherData w) {
		this.data = w;
		w.registerObserver(this);
	}
	
	//
	public void update(int temp, int pres, int humi) {
		this.temp = temp;
		this.pres = pres;
		this.humi = humi;
		display();
	}
	
	public void display() {
		System.out.println("Current Temperature: " + temp + 
				" Humidity: " + humi +
				" Pressure: " + pres);
	}
}

public class ObserverPattern {

	public static void main(String[] args) {
		WeatherData wd = new WeatherData();
		CurrentConditionDisplayer cc = new CurrentConditionDisplayer(wd);
		
		wd.setMeasurements(10, 10, 10);
	}

}
