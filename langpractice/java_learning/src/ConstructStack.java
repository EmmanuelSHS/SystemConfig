/**
 * Stack made by LinkedList/ Generic LinkedList
 * no inheritance, since methods would be more than necessary
 */

import java.util.LinkedList;

class StackList<T> {
	private LinkedList<T> list = new LinkedList<T>();
	/** T in the above and following codes is a random generics */
	public void push(T t) {
		list.addFirst(t);
	}
	public T top() {
		return list.getFirst();
	}
	public T pop() {
		return list.removeFirst();
	}
}
public class ConstructStack {

	public static void main(String[] args) {
		StackList<String> s = new StackList<String>();
		s.push("cat");
		s.push("dog");
		s.push("monkey");
		s.pop();
		System.out.println(s.top());
	}

}
