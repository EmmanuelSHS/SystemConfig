import javax.swing.*;
public class JFrameDemo {
	public static void main (String[] args) {
		JFrame frame = new JFrame("JFrame example");
		System.out.println("JFrame initialized");
		frame.setSize(400, 400);
		frame.setLocation(200, 200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// HIDE_ON_CLOSE DISPOSE_ON_CLOSE are other common operations
	}
}
