package headFirstDesignPattern;

abstract class Beverage {
	String desc = "Not a beverage";
	
	public String getDesc() {
		return desc;
	};
	
	public abstract double cost();
}

abstract class Decorator extends Beverage {
	public abstract String getDesc();
}

class Espresso extends Beverage {
	public Espresso() {
		desc = "Expresso";
	}
	
	public double cost() {
		return 1.99;
	}
}

class Milk extends Decorator {
	private Beverage beverage;
	
	Milk(Beverage b) {
		this.beverage = b;
	}
	
	public String getDesc() {
		return this.beverage.getDesc() + ", with Milk";
	}
	
	public double cost() {
		return this.beverage.cost() + 0.5;
	}
}


public class DecoratorPattern {

	public static void main(String[] args) {
		Beverage b1 = new Espresso();
		b1 = new Milk(b1);
		System.out.println(b1.cost());
		
		b1 = new Milk(b1);
		System.out.println(b1.cost());
	}

}
