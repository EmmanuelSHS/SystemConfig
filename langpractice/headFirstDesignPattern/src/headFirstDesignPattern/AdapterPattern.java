package headFirstDesignPattern;

interface Turkey {
	public void gobble();
	public void fly();
}

class WildTurkey implements Turkey {
	public void gobble() {
		System.out.println("Gobble");
	}
	
	public void fly() {
		System.out.println("fly a short distance");
	}
}

interface Duck {
	public void quack();
	public void fly();
}

// Adapter: Concrete class implements transformation
class TurkeyAdapter implements Duck {
	Turkey turkey;
	
	TurkeyAdapter(Turkey turkey) {
		this.turkey = turkey;
	}
	
	public void quack() {
		turkey.gobble();
	}
	
	public void fly() {
		for (int i = 0; i < 5; ++i) {
			turkey.fly();
		}
	}
}

public class AdapterPattern {

	public static void main(String[] args) {
		Turkey t = new WildTurkey();
		t.gobble();
		t.fly();
		
		Duck at = new TurkeyAdapter(t);
		at.quack();
		at.fly();
	}

}
