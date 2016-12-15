import java.util.*;

public class ScannerExample {
	public static void main(String[] args) {
		System.out.println("please input any number, end by ENTER");
		System.out.println("End by non-number");
		Scanner reader = new Scanner(System.in);
		/** seal the system.in as reader */
		double sum = 0;
		int m = 0;
		while (reader.hasNextDouble()) {
			double x = reader.nextDouble();
			m = m + 1;
			sum = sum + x;
		}
		System.out.println(m + " numbers, total " + sum);
		System.out.println(m + "numbers, ave " + sum/m);
	}

}
