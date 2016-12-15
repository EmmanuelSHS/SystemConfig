package headFirstDesignPattern;

abstract class CaffineBeverage {
	public void makeBeverage() {
		boilWater();
		brew();
		pour();
		if (wantCondiments())
			addCondiments();
	}
	
	abstract boolean wantCondiments();
	abstract void brew();
	abstract void addCondiments();
	
	void boilWater() {
		System.out.println("Boil water");
	}

	void pour() {
		System.out.println("Pouring into cup");
	}
}

class Tea extends CaffineBeverage {
	public Tea() {
	}
	
	boolean wantCondiments() {
		return false;
	}
	
	void brew() {
		System.out.println("Pull teabag in hot water");
	}
	
	void addCondiments() {
		System.out.println("Actually no need for condiments");
	}
}

class Coffee extends CaffineBeverage {
	public Coffee() {
	}
	
	boolean wantCondiments() {
		return true;
	}
	
	void brew() {
		System.out.println("Pull teabag in hot water");
	}
	
	void addCondiments() {
		System.out.println("Milk added");
	}
}

public class TemplateMethodPattern {
	public static void main (String[] args) {
		Tea t = new Tea();
		Coffee c = new Coffee();
		t.makeBeverage();
		c.makeBeverage();
	}
}
