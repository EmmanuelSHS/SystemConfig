/* 
 * to distinguish local variables and global ones.
 * local variables belongs to methods, the existence of which is inside the methods
 * the global ones lie in the class, not a method, a function
 * in other words, global variables and methods are equal inside the class.
 */

/*
 * Static value is like a pointer
 * s1.x & s2.x is only the name of the pointer, their value are of the same address
 * since they belong to the same class
 * Hence the change of the value makes them both changed
 * while non-static values from diff. instances have their own memory address 
 * even if they were from
 * the same variable of the same class.
 * 
 * The eg may provide you with more insights.
 * 
 * Moreover, static variables/methods could be created without any instance
 * that's why the main method needs public static
 */

class StaticVarTest {
	static int x=100;
	int y=1;
	public StaticVarTest(){};
}

public class StaticVarTestDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StaticVarTest s1=new StaticVarTest();
		StaticVarTest s2=new StaticVarTest();
		System.out.println("before x modification, s1.x="+s1.x+" s2.x="+s2.x);
		s1.x++;
		System.out.println("after x modification, s1.x="+s1.x+" s2.x="+s2.x);
		System.out.println("before y modification, s1.y="+s1.y+" s2.y="+s2.y);
		s1.y++;
		System.out.println("after y modification, s1.y="+s1.y+" s2.y="+s2.y);
		
	}

}
