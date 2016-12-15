class OuterLIC {
	private int s = 100;
	private int out_i = 1;
	public void f(final int k) {
		final int s = 200;
		int i = 1;
		final int j = 10;
		// inner class defined in method
		class InnerLIC {
			int s = 300;
			InnerLIC(int k) {
				inner_f(k);
			}
			int inner_i = 100;
			void inner_f(int k) {
				System.out.println(out_i);// directly access outer global field
				System.out.println(j);// outer local field
				System.out.println(s);// inner field, the same as this.s
				System.out.println(this.s);
				System.out.println(OuterLIC.this.s);//OuterClassName.this.field
			}
		}
		new InnerLIC(k);
	}
}
public class LocalInnerClass {
	public static void main(String[] args) {
		OuterLIC out = new OuterLIC();
		out.f(3);
	}
}
