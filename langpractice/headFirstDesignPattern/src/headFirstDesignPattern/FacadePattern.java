package headFirstDesignPattern;

// Facade is a concrete class that combines all subsystems (classes) into it
// and unify all related methods into one
class HomeTheatreFacade {
	TV tv;
	PopcornPopper popper;
	
	public HomeTheatreFacade(TV tv, PopcornPopper popper) {
		this.tv = tv;
		this.popper = popper;
	}
	
	public void on() {
		tv.on();
		popper.on();
		popper.hold();
	}
	
	public void off() {
		System.out.println("Movie is over");
		tv.off();
		popper.off();
	}
}

class TV {
	public TV() {
	}
	
	public void on() {
		System.out.println("TV is on");
	}
	
	public void off() {
		System.out.println("TV is off");
	}
}

class PopcornPopper {
	public PopcornPopper() {
	}
	
	public void on() {
		System.out.println("Preparing Popcorn");
		System.out.println("Popcorn ready");
	}
	
	public void hold() {
		System.out.println("Constantly making more popcorn");
	}
	
	public void off() {
		System.out.println("Popcorn popper off");
	}
}

public class FacadePattern {

	public static void main(String[] args) {
		TV tv = new TV();
		PopcornPopper popper = new PopcornPopper();
		HomeTheatreFacade facade = new HomeTheatreFacade(tv, popper);
		
		facade.on();
		facade.off();
	}

}
