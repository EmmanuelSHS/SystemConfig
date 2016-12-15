package headFirstDesignPattern;

interface State {
	public void insertQuarter();
	public void ejectQuarter();
	public void turnCrank();
	public void dispense();
}

class SoldState implements State {
	private GumballMachine gm;
	
	public SoldState(GumballMachine gm) {
		this.gm = gm;
	}
	
	public void insertQuarter() {
		System.out.println("Plz wait, we're already giving you a gumball");
	};
	
	public void ejectQuarter() {
		System.out.println("Sorry, you alread turned the crank");
	};
	
	public void turnCrank() {
		System.out.println("Turing twice will not give you another gumball");
	};
	
	public void dispense() {
		gm.releaseBall();
		if (gm.getCount() > 0) {
			gm.setState(gm.getNoQuarterState());
		} else {
			System.out.println("Ooops, out of gumballs");
			gm.setState(gm.getSoldOutState());
		}
	};
}

class SoldOutState implements State {
	private GumballMachine gm;
	
	public SoldOutState(GumballMachine gm) {
		this.gm = gm;
	}
	
	public void insertQuarter() {
		System.out.println("You can not insert a quarter, the machin is sold out");
	};
	
	public void ejectQuarter() {
		System.out.println("You can not eject, you have not inserted a quarter yet");
	};
	
	public void turnCrank() {
		System.out.println("You turned, but there are no gumballs");
	};
	
	public void dispense() {
		System.out.println("No gumball dispensed");
	};
}

class NoQuarterState implements State {
	private GumballMachine gm;
	
	public NoQuarterState(GumballMachine gm) {
		this.gm = gm;
	}
	
	public void insertQuarter() {
		System.out.println("You inserted a quarter");
		gm.setState(gm.getHasQuarterState());
	};
	
	public void ejectQuarter() {
		System.out.println("You have not inserted a quarter");
	};
	
	public void turnCrank() {
		System.out.println("You turned, but there is no quarter");
	};
	
	public void dispense() {
		System.out.println("You need to pay first");
	};
}

class HasQuarterState implements State {
	private GumballMachine gm;
	
	public HasQuarterState(GumballMachine gm) {
		this.gm = gm;
	}
	
	public void insertQuarter() {
		System.out.println("You can't insert another quarter");
	};
	
	public void ejectQuarter() {
		System.out.println("Quarter returned");
		gm.setState(gm.getSoldState());
	};
	
	public void turnCrank() {
		System.out.println("You turned...");
		gm.setState(gm.getSoldState());
	};
	
	public void dispense() {
		System.out.println("No gumball dispensed");
	};
}


class GumballMachine {
	State sold;
	State out;
	State has;
	State no;
	
	State curr = out;
	private int count = 0;
	
	public GumballMachine(int nGumballs) {
		sold = new SoldState(this);
		out = new SoldOutState(this);
		has = new HasQuarterState(this);
		no = new NoQuarterState(this);
		this.count = nGumballs;
		if (nGumballs > 0)
			curr = no;
	}
	
	public void releaseBall() {
		System.out.println("A gumball comes rolling out the slot...");
		if (count != 0)
			count--;
	}
	
	public void insertQuarter() {
		curr.insertQuarter();
	};
	
	public void ejectQuarter() {
		curr.ejectQuarter();
	};
	
	public void turnCrank() {
		curr.turnCrank();
		curr.dispense();
	};
	
	public void setState(State s) {
		curr = s;
	}
	
	public State getSoldState() {
		return sold;
	}
	
	public State getSoldOutState() {
		return out;
	}
	
	public State getHasQuarterState() {
		return has;
	}
	
	public State getNoQuarterState() {
		return no;
	}
	
	public int getCount() {
		return count;
	}
	
}


public class StatePattern {

	public static void main(String[] args) {
		GumballMachine gm = new GumballMachine(10);
		
		System.out.println(gm);
		
		// state transfer achieved by class
		gm.insertQuarter();
		gm.turnCrank();
		gm.insertQuarter();
		gm.turnCrank();
		gm.turnCrank();
		gm.insertQuarter();
		gm.insertQuarter();
	}

}
