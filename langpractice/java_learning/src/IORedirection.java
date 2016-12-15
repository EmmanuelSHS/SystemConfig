/**
 * I/O Stream is like the pipeline
 */

import java.io.*;

public class IORedirection {

	public static void main(String[] args) throws IOException {
		PrintStream consoleout = System.out;
		InputStream consolein = System.in;
		BufferedInputStream in = new BufferedInputStream(
				new FileInputStream("Redirecting.java"));
		PrintStream out = new PrintStream(
				new BufferedOutputStream(
						new FileOutputStream("test.out")));
		System.setIn(in);
		System.setOut(out);
		System.setErr(out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while((s = br.readLine()) != null)
			System.out.println(s);
		out.close();
		System.setOut(consoleout);
		in.close();
		System.setIn(consolein);
	}

}
