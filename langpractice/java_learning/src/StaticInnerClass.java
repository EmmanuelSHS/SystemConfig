/*
 * to demonstrate that:
 * 1. static inner class is independent of the outer object
 * 2. static inner class can only gain access to the static outer object
 * 3. to get acess to the non-static mmbr of inner class, outer class need to initialize the inner
 */
class Outer {
	private static int i = 1;
	private int j = 10;
	public static void outer_f1() {
		
	}
	public static void outer_f2() {
		
	}
	
	static class Inner {
		static int inner_i = 100;
		int inner_j = 200;
		static void inner_f1() {
			System.out.println("Outer.i " + i);
			outer_f1();
		}
		void inner_f2() {
			// can't get access to the non-static members of the outer class
			// System.out.println("Outer.j" + j);
			// the above sentence would cause error
			// outer_f2();
		}
	}
	
	public void outer_f3() {
		System.out.println(Inner.inner_i);
		//User Innerclassname.static-innermmbr to get access to inner members
		Inner.inner_f1();
		Inner inner = new Inner();
		inner.inner_f2();
	}
}
public class StaticInnerClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Outer().outer_f3();
	}

}
