package headFirstDesignPattern;

abstract class Ingredient {
	protected String desc;
	public String getDesc() {
		return this.desc;
	}
}

class ThinCrustDough extends Ingredient {
	ThinCrustDough() {
		desc = "Thin Crust Dough";
	}
}

class ThickDough extends Ingredient {
	ThickDough() {
		desc = "Thick Dough";
	}
}

class MarianaSauce extends Ingredient {
	MarianaSauce() 	{
		desc = "Mariana Sauce";
	}
}

class TartarSauce extends Ingredient {
	TartarSauce() {
		desc = "Tartar Sauce";
	}
}


interface IngredientFactory {
	public Ingredient createDough();
	public Ingredient createSauce();
}

class NYIngredientFactory implements IngredientFactory {
	public Ingredient createDough() {
		return new ThinCrustDough();
	}
	
	public Ingredient createSauce() {
		return new MarianaSauce();
	}
}

class ChicagoIngredientFactory implements IngredientFactory {
	public Ingredient createDough() {
		return new ThickDough();
	}
	
	public Ingredient createSauce() {
		return new TartarSauce();
	}
}

abstract class AFPizza {
	protected IngredientFactory factory;
	protected Ingredient sauce;
	protected Ingredient dough;
	protected String topping;
	//abstract protected void prepare();
	public String getDesc() {
		return sauce.getDesc() + " " + dough.getDesc() + " " + topping;
	}
}

class AFCheesePizza extends AFPizza {
	AFCheesePizza(IngredientFactory factory) {
		this.factory = factory;
		this.sauce = this.factory.createDough();
		this.dough = this.factory.createSauce();
		this.topping = "Cheese";
	}
}

class AFPlainPizza extends AFPizza {
	AFPlainPizza(IngredientFactory factory) {
		this.factory = factory;
		this.sauce = this.factory.createDough();
		this.dough = this.factory.createSauce();
		this.topping = "Nothing";
	}
}


abstract class PizzaStore {
	protected AFPizza pizza;
	protected IngredientFactory factory;
	abstract protected void createPizza(String type);
	public String getDesc() {
		return pizza.getDesc();
	};
}

class AFNYStore extends PizzaStore {
	AFNYStore() {
		pizza = null;
		factory = new NYIngredientFactory();
	}
	
	protected void createPizza(String type) {
		if (type.equals("cheese")) {
			pizza = new AFCheesePizza(factory);
		} else if (type.equals("plain")) {
			pizza = new AFPlainPizza(factory);
		}
	}
}

class AFChicagoStore extends PizzaStore {
	AFChicagoStore() {
		pizza = null;
		factory = new ChicagoIngredientFactory();
	}
	
	protected void createPizza(String type) {
		if (type.equals("cheese")) {
			pizza = new AFCheesePizza(factory);
		} else if (type.equals("plain")) {
			pizza = new AFPlainPizza(factory);
		}
	}
}

public class AbstractFactoryPattern {

	public static void main(String[] args) {
		//IngredientFactory nyf = new NYIngredientFactory();
		//IngredientFactory caf = new ChicagoIngredientFactory();

		PizzaStore ny = new AFNYStore();
		PizzaStore ca = new AFChicagoStore();
		
		ny.createPizza("cheese");
		System.out.println(ny.getDesc());
		
		ca.createPizza("plain");
		System.out.println(ca.getDesc());
	}

}
