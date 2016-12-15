/*
 * to show what is inner class, &
 * how to create constructor for anonymous inner class:
 * 1. call constructor from its super class via super.xxx
 * 2. use final keyword to create a constructor for anonymous class
 * 3. initialization inside anonymous class
 */

public class AnonymousInnerClass {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InnerTest1 inner = new InnerTest1();
		OuterTest1 t = inner.get(3);
		System.out.println(t.getI());
		
		OuterTest2 p = new OuterTest2();
		InnerTest2 d = p.dest("Tanzania");
	}
	// initialization insdie anonymous class, but a interface/abstract class should be created first
	/*
	public InnerTest2 innertest(final String dest, final float price) {
		return new InnerTest2() {
			private int cost;
			private String label = dest;
			{// initilization code
				cost = Math.round(price);
				if (cost > 100) System.out.println("Over budget!");
			}
			public String readLabel() {
				return label;
			}
		};
	}
	*/
}

// call constructor from super class
class OuterTest1 {
	private int i;
	public OuterTest1(int i) {
		this.i = i;
	}
	public int getI() {
		return i;
	}
}
class InnerTest1 {
	public OuterTest1 get(int x) {
		return new OuterTest1(x) {
			public int getI() {
				return super.getI() * 10;
			}
		};// an additional ';' is needed for this construction
	}
}

// use final
interface InnerTest2 {
	String readLabel();
}
class OuterTest2{
	public InnerTest2 dest(final String dest) {
		return new InnerTest2() {
			private String label = dest;
			public String readLabel() {
				return label;
			}
		};
	}
}
