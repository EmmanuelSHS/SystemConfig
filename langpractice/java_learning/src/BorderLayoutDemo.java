import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
// why this needs extends while FlowLayoutDemo needs not?
// since superclass methods are in need for constructor
public class BorderLayoutDemo extends JFrame implements ActionListener {
	private JButton buttons[];
	private String btnames[] = {"HN", "HS", "HE", "HW", "HC"};
	private BorderLayout layout;
	public BorderLayoutDemo() { // constructor
		super("BorderLayout eg");
		layout = new BorderLayout(5, 5);
		Container container = getContentPane();
		container.setLayout(layout);
		buttons = new JButton[btnames.length];
		for (int count = 0; count < btnames.length; count++) {
			buttons[count] = new JButton(btnames[count]);
			buttons[count].addActionListener(this);//?
		}
		container.add(buttons[0], BorderLayout.NORTH);
		container.add(buttons[1], BorderLayout.SOUTH);
		container.add(buttons[2], BorderLayout.EAST);
		container.add(buttons[3], BorderLayout.WEST);
		container.add(buttons[4], BorderLayout.CENTER);
		setSize(300, 300);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent event) {
		for (int count = 0; count < buttons.length; count++) {
			if (event.getSource() == buttons[count])
				buttons[count].setVisible(true);
			else
				buttons[count].setVisible(true);
			layout.layoutContainer(getContentPane());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BorderLayoutDemo app = new BorderLayoutDemo();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
