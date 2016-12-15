/*
 * this eg provide you a better understanding of overload & Polymophism,
 * override and inheritance also included.
 * main objects: tri, shape, shape2, rec
 * tri is from class Tria;
 * shape/shape2 are both from class Shape, while has polymophism from Tria/Recta.
 */

class Shape {
	public boolean isShape(){
		return true;
	}
	public int getSides(){
		return 00;
	}
	public int getSides(Tria tri){// Overload
		return 30;
	}
	public int getSides(Recta rec){// Overload
		return 40;
	}
}
class Tria extends Shape {
	public int getSides(){// Override
		return 33;
	}
}
class Recta extends Shape {
	public int getSides(int i){// Overload
		return i*7;
	}
}
public class OverloadVsPolymophism {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tria tri = new Tria();
		System.out.println(tri.isShape());// Inheritance -- Tria->Shape::isShape()
		System.out.println(tri.getSides());// Inheritance -- Tria::getSides()
		System.out.println(tri.getSides(new Tria()));// Inheritance & Overload -- Tria->Shape::getSides(Tria)
		// not usually used maybe
		Shape shape = new Tria();
		System.out.println(shape.getSides());// Polymophism -- Shape->Tria::getSides()
		Recta rec = new Recta();
		Shape shape2 = rec;
		System.out.println(shape2.getSides(rec));//Overload -- Shape::getSides(Recta)
		System.out.println(rec.getSides(4));// Inheritance & Overload -- Recta::getSides(int)
	}

}
