import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JTextFieldDemo extends JFrame {
	private JTextField textField1, textField2, textField3;
	private JPasswordField passwordField;
	public JTextFieldDemo() { // why always this? anonymous?
		super("JTextField eg");
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		textField1 = new JTextField(17);// this int means?
		container.add(textField1);
		textField2 = new JTextField("text input here");
		container.add(textField2);
		textField3 = new JTextField("inEditable", 22);
		textField3.setEditable(false);
		container.add(textField3);
		passwordField = new JPasswordField("Here is password field");
		container.add(passwordField);
		TextFieldHandler handler = new TextFieldHandler();
		textField1.addActionListener(handler);
		textField2.addActionListener(handler);
		textField3.addActionListener(handler);
		passwordField.addActionListener(handler);
		setSize(400, 400);
		setVisible(true);
	}
	private class TextFieldHandler implements ActionListener {
		public void actionPerformed( ActionEvent event) {
			String string = "";
			if (event.getSource() == textField1)
				string = "txtField 1: " + event.getActionCommand();
			else if (event.getSource() == textField2)
				string = "txtField 2: " + event.getActionCommand();
			else if (event.getSource() == textField3)
				string = "txtField 3: " + event.getActionCommand();
			else if (event.getSource() == passwordField) {
				string = "passwordField : " + event.getActionCommand();
				new String(passwordField.getPassword());
			}
			JOptionPane.showMessageDialog(null, string);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JTextFieldDemo app = new JTextFieldDemo();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
