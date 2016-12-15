// Components in flow layout will change with the size of container.

import java.awt.FlowLayout;
import javax.swing.*;

public class FlowLayoutDemo {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("FlowLayout eg");
		frame.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 30));
		JButton button = null;
		for (int i = 1; i <= 12; i++) {
			button = new JButton ("Button" + i);
			frame.add(button);
		}
		frame.setSize(360, 300);
		frame.setLocation(200, 200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
