import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JButtonDemo extends JFrame {
	private JButton plainButton, imgButton;
	public JButtonDemo() {
		super("Button eg");
		Container container = getContentPane();// ?
		container.setLayout(new FlowLayout());
		plainButton = new JButton("Ordinary");
		container.add(plainButton);
		Icon img = new ImageIcon();
		imgButton = new JButton("with Pic (eg only)");
		container.add(imgButton);
		ButtonHandler handler = new ButtonHandler();
		imgButton.addActionListener(handler);
		plainButton.addActionListener(handler);
		setSize(600,160);
		setVisible(true);
	}
	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JOptionPane.showMessageDialog(null, 
					"in button " + event.getActionCommand() + " you click");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JButtonDemo app = new JButtonDemo();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
