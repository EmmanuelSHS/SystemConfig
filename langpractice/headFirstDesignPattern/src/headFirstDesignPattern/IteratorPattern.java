package headFirstDesignPattern;

interface Iterator {
	boolean hasNext();
	Object next();
}

class IntArrayIterator implements Iterator {
	int position;
	Integer[] array;
	
	public IntArrayIterator(Integer[] a) {
		this.array = a;
		position = 0;
	}
	
	public boolean hasNext() {
		if (position >= array.length || array[position] == null)
			return false;
		else
			return true;
	}
	
	public Object next() {
		Object o = array[position];
		position++;
		return o;
	}
}

class IntArray {
	Integer[] array;
	
	public IntArray(Integer[] a) {
		this.array = a;
	}
	
	public Iterator getIterator() {
		return new IntArrayIterator(this.array);
	}
}

public class IteratorPattern {
	public static void main(String[] args) {
		IntArray array = new IntArray(new Integer[] {1,2,3});
		Iterator it = array.getIterator();
		
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
