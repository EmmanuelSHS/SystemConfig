package headFirstDesignPattern;

abstract class Pizza {
	protected String style;
	protected String topping;
	public String getDesc() {
		return this.style + " " + this.topping;
	};
}

class NYCheesePizza extends Pizza{
	NYCheesePizza() {
		style = "NY";
		topping = "cheese";
	}
}

class ChicagoCheesePizza extends Pizza {
	ChicagoCheesePizza() {
		style = "Chicago";
		topping = "cheese";
	}
}

class NYPlainPizza extends Pizza {
	NYPlainPizza() {
		this.style = "NY";
		this.topping = "Nothing";
	}
}

class ChicagoPlainPizza extends Pizza {
	ChicagoPlainPizza() {
		this.style = "Chicago";
		this.topping = "Nothing";
	}
}


abstract class Store {
	protected Pizza pizza;
	abstract public Pizza makePizza(String type);
}

class NYStore extends Store {
	NYStore() {
		pizza = null;
	}
	
	public Pizza makePizza(String type) {
		if (type.equals("cheese")) {
			pizza = new NYCheesePizza();
		} else if (type.equals("plain")) {
			pizza = new NYPlainPizza();
		}
		
		return pizza;
	}
}

class ChicagoStore extends Store {
	ChicagoStore() {
		pizza = null;
	}
	
	public Pizza makePizza(String type) {
		if (type.equals("cheese")) {
			pizza = new ChicagoCheesePizza();
		} else if (type.equals("plain")) {
			pizza = new ChicagoPlainPizza();
		}
		
		return pizza;
	}
}


public class FactoryPattern {

	public static void main(String[] args) {
		NYStore ny = new NYStore();
		ChicagoStore ca = new ChicagoStore();
		
		Pizza p1 = ny.makePizza("cheese");
		System.out.println(p1.getDesc());
		
		Pizza p2 = ca.makePizza("plain");
		System.out.println(p2.getDesc());
	}

}
