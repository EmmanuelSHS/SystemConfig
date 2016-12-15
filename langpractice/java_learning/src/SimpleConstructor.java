/*
 * this eg provides you with insight into usage of constructors:
 * the constructor (Rock() in class Rock()) has the same name as the class'.
 * with/without para are both acceptable.
 */

class Rock{
	Rock(){
		System.out.print("Rock&");
	}
}

class Roll{
	Roll(int i){
		System.out.print("Roll " + i + " ");
	}
}

public class SimpleConstructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0; i < 5; i++) {
			new Rock();
			new Roll(i);
		}
	}

}
