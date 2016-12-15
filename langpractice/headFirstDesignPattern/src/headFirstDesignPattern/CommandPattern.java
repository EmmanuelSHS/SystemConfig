package headFirstDesignPattern;

interface Command {
	public void execute();
}

class LightCommand implements Command {
	LightCommand() {};
	
	public void execute() {
		System.out.println("light on");
	}
}

class ACCommand implements Command {
	ACCommand() {};
	
	public void execute() {
		System.out.println("AC on");
	}
}

class SimpleController {
	Command slot;
	
	SimpleController() {
		this.slot = null;
	}
	
	public void setCommand(Command slot) {
		this.slot = slot;
	}
	public void pressButton() {
		if (this.slot == null)
			System.out.println("Command not set");
		else
			slot.execute();
	}
}

public class CommandPattern {

	public static void main(String[] args) {
		SimpleController control = new SimpleController();
		LightCommand light = new LightCommand();
		ACCommand ac = new ACCommand();
		
		control.setCommand(light);
		control.pressButton();
		
		control.setCommand(ac);
		control.pressButton();
	}

}
