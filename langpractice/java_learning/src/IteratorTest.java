import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class IteratorTest {

	public static void main(String[] args) {
		List<String> s = new ArrayList<String>();
		s.add("1");
		s.add("2");
		s.add("String");
		for (Iterator<String> it = s.iterator(); it.hasNext(); ) {
			String temp = it.next();
			System.out.println(temp);
		}
	}

}
