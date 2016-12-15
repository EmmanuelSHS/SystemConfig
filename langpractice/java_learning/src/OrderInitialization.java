/*
 * order of initialization are such inside class:
 * firstly the static members are initialized
 * the first time they are accessed to;
 * then variables > methods, even if they are distributed among methods.
 * & inside each type, the initialization happen by coding order.
 */

class Window{
	Window(int marker) {
		System.out.println("Window(" + marker + ") ");

	}
}
class House{
	Window w1 = new Window(1);
	House() {
		System.out.println("House()");
		w3 = new Window(33);
	}
	Window w2 = new Window(2);
	void f() {
		System.out.println("f()");
	}
	Window w3 = new Window(3);
}
public class OrderInitialization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		House h = new House();
		h.f();
	}

}
