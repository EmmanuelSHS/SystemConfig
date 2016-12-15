
public interface ClassInInterface {
	void howdy();
	class TestClassInInterface implements ClassInInterface {
		public void howdy() {
			System.out.println("Howdy!");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestClassInInterface().howdy();
	}

}
