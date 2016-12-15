/*
 * Upcasting example.
 * Child inherits Father, & overload (overload, not override!) func1(), override func2().
 * After overloading, func1(int) & func1() are diff.,
 * since the Super Class has no func1(int), child, which is the instance of Super Class -- Father,
 * can't call func1(int) method.
 * However, the func2() is overrided, hence child will call the func2() from Sub Class -- Child.
 * 
 * ?In short, Upcasting can 'directly' call overriding from Sub Class.
 * Upcasting is automatic.
 */

class Father {
	public void func1(){
		func2();
	}
	public void func2(){
		System.out.println("AAA");
	}
}
class Child extends Father {
	public void func1(int i){
		System.out.println("BBB");
	}
	public void func2(){
		System.out.println("CCC");
	}
}
public class Upcasting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Father child = new Child();
		child.func1();
	}

}
