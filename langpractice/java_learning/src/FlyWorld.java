/**
 * 
 * @author Emmanuel-PC
 * @Time 2015-05-21
 * @param Fly, Land, Begin, End 接口
 * @param Flyable 飞行类
 * @param Bird, Airplane, Superman 飞行类的子类
 */

interface Fly { public void fly();}
interface Land { public void land();}
interface Begin { public void begin();}
interface End { public void end();}

public class FlyWorld {

	/**
	 * 运行飞行世界
	 * @param main main function for Flyworld
	 * @param ld land function
	 * @param fy fly function
	 * @param bg begin function
	 * @param ed end function
	 */
	
	public static void main(String [] args)
	{
		FlyWorld f = new FlyWorld();
		Bird b = new Bird();
		Airplane a = new Airplane();
		Superman s = new Superman();
		
		f.bg(b);
		f.fy(b);
		f.ld(b);
		f.fy(a);
		f.ld(a);
		f.fy(s);
		f.ld(s);
		f.ed(s);
	}

	public void ld (Land l) { l.land();}
	public void fy (Fly f) { f.fly();}
	public void bg (Flyable b) { b.begin();}
	public void ed (Flyable e) { e.end();}

}

abstract class Flyable implements Fly, Land, Begin, End {
	/**
	 * @param name, 某一类的飞行了类的名字
	 * @param begin, end 开始飞行、结束飞行类
	 * @param fly, land 飞行，降落类
	 */
	protected String name;
	public final void begin() { System.out.println("start!");}
	public final void end() { System.out.println("the end");}
	public void fly() { System.out.println("fly flyable");}
	public void land() { System.out.println("landed");}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

class Bird extends Flyable implements Fly, Land, Begin, End {

	private final String type = "Bird";
	public void fly() { System.out.println("fly "+this.type);}
	public void land() { 
		System.out.println("land bird");
		super.land();
	}	
}

class Airplane extends Flyable implements Fly, Land, Begin, End {
	private final String type = "Plane";
	public void fly() { System.out.println("fly "+this.type);}
	public void land() { 
		super.land();
	}
}

class Superman extends Flyable implements Fly, Land, Begin, End {
	private final String type = "Superman";
	public void fly() { System.out.println("fly "+this.type);}
	public void land() { 
		System.out.println("land superman");
		super.land();
	}
}