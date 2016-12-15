/*
 * this eg provides with insights into Binding
 */
class Super {
	protected String name = "Super properties";
	public String getName() {
		return name;
	}
	public void UpcastingDynamicBinding() {
		System.out.println("SupClass, ObjType: " + this.getClass());
	}
	public void UpcastingOverride() {
		System.out.println("SupClass, ObjType: " + this.getClass());
	}
	
}
class Sub extends Super {
	protected String name = "Sub properties";
	public String getName() {
		return name;
	}
	public void UpcastingOverride() {
		System.out.println("SubClass, ObjType: " + this.getClass());
	}
}
public class Binding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Super sample = new Sub();
		// Dynamic binding 
		sample.UpcastingDynamicBinding();
		// Override in sub has higher priority
		sample.UpcastingOverride();
		// Static binding
		// Obj. of Sub. calls mmb. from Sup.
		System.out.println("Call from: " + sample.name);
		// getter enables calling mmb. from Sub.
		System.out.println("Call from: " + sample.getName());
		
	}

}
