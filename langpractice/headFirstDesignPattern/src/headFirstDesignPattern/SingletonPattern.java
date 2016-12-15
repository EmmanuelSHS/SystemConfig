package headFirstDesignPattern;

/*
 * Save resource as to create object only once
 */

class SingletonClass {
	private String desc;
	private volatile static SingletonClass singleton;
	
	private SingletonClass() {
		desc = "init";
	}
	
	public static SingletonClass getInstance() {
		if (singleton == null) {
			//param is object
			synchronized (SingletonClass.class) {
				// check again so that no other thread has created in advance
				if (singleton == null) {
					singleton = new SingletonClass();
				}
			}
		}
		
		return singleton;
	}
	
	public String getDesc() {
		return desc;
	}
}

public class SingletonPattern {

	public static void main(String[] args) {
		SingletonClass s = SingletonClass.getInstance();
		System.out.println(s.getDesc());
	}

}
