package headFirstDesignPattern;

abstract class Character {
	WeaponBehavior weapon;
	
	public void setWeaponBehavior(WeaponBehavior w) {
		this.weapon = w;
	}
	
	public void attack() {
		this.weapon.useWeapon();
	}
}

interface WeaponBehavior {
	public void useWeapon();
}

class SwordBehavior implements WeaponBehavior {
	public void useWeapon() {
		System.out.println("Sword");
	}
}

class KnifeBehavior implements WeaponBehavior {
	public void useWeapon() {
		System.out.println("Knife Stab");
	}
}

class BowAndArrowBehavior implements WeaponBehavior {
	public void useWeapon() {
		System.out.println("Arrow Out");
	}
}

class AxeBehavior implements WeaponBehavior {
	public void useWeapon() {
		System.out.println("Axe Chop");
	}
}

class King extends Character {
	public King() {
		weapon = new SwordBehavior();
	}
}

class Queen extends Character {
	public Queen() {
		weapon = new KnifeBehavior();
	}
}

class Knight extends Character {
	public Knight() {
		weapon = new AxeBehavior();
	}
}

class Troll extends Character {
	public Troll() {
		weapon = new BowAndArrowBehavior();
	}
}

public class StrategyPattern {
	public static void main(String[] args) {
		Character c1 = new Queen();
		c1.attack();
		c1.setWeaponBehavior(new SwordBehavior());
		c1.attack();
		
		Character c2 = new King();
		c2.attack();
		
		Character c3 = new Troll();
		c3.attack();
		
		Character c4 = new Knight();
		c4.attack();
	}
}
