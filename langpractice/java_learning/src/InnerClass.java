// inner class could be directly created via:
// Outer.Inner inner = outerobject.new Inner();

interface Contents {
	int value();
}
interface Destination {
	String readLabel();
}

class Goods {
	private int valueRate = 2;
	// inner class Content and GDestination are created
	private class Content implements Contents {
		private int i = 11 * valueRate;
		// inner class can get access to its outer class mmbrs, even if they're private
		public int value() {
			return i;
		}
	}
	protected class GDestination implements Destination {
		private String label;
		private GDestination(String whereTo) {
			label = whereTo;
		}
		public String readLabel() {
			return label;
		}
	}
	
	// initialize the inner class
	public Destination dest(String s) {
		return new GDestination(s);
	}
	public Contents cont() {
		return new Content();
	}
}
public class InnerClass {
	public static void main(String[] args) {
		Goods p = new Goods();
		Contents c = p.cont();
		// also 'new' keyword could be used for creating inner object:
		// outerObject = new outerClass(Constructor Parameters);
		// outerClass.innerClass innerObject = outerObject.new InnerClass(Constructor Para)
		// i.e. Goods.Content c = p.new Content(); However, class Content is private in this case
		Destination d = p.dest("Beijing");
		System.out.println(d.readLabel());
	}
}
