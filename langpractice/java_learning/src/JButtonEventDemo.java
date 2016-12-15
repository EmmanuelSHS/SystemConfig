/**
 * Common ActionListener & ActionEvent mmbrs:
 * ActionListener: actionPerformed()
 * ActionEvent: getActionCommand() getSource()
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JButtonEventDemo extends JFrame implements ActionListener {
	private JLabel message = new JLabel("Please click belowing buttons");
	private JButton JB1, JB2;
	private JPanel JPButtons, JPMessage; /** Two panels in one container */
	public JButtonEventDemo() {
		setTitle("Button event eg");
		JPButtons = new JPanel();
		JPMessage = new JPanel();
		JPButtons.setLayout(new FlowLayout());
		JPMessage.setLayout(new FlowLayout());
		JPMessage.add(message);
		JPButtons.add(JB1 = new JButton("Button 1"));
		JPButtons.add(JB2 = new JButton("Button 2"));
		/** add two panels to content */
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(JPMessage, BorderLayout.CENTER);
		getContentPane().add(JPButtons, BorderLayout.SOUTH);
		JB1.addActionListener(this);
		JB2.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		String temp = e.getActionCommand(); /** Return command string */
		System.out.println("getActionCommand knows you're clicking"
				+ temp);
		if (e.getSource() == JB1) { /** return command source*/
			message.setText("on JB1 you click");
			JPMessage.updateUI();
			JPButtons.updateUI();
		}
		else if (temp.equalsIgnoreCase("Button 2")) {
			message.setText("on JB2 you click");
			JPMessage.updateUI();
			JPButtons.updateUI();
			}
	}
	public static void main(String[] args) {
		/** if don't extends, the setSize setVisible methods 
			aren't applicable in JButtonEvenDemo class */
		JButtonEventDemo jb = new JButtonEventDemo();
		jb.setSize(220, 120);
		jb.setVisible(true);
	}

}
