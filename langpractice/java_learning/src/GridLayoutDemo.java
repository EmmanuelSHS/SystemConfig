import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GridLayoutDemo extends JFrame implements ActionListener {
	private JButton buttons[];
	private String names[] = {"1", "2", "3", "4", "5", "6", "7", "8"};
	private boolean	toggle = true;
	private Container container;
	private GridLayout grid1, grid2;
	public GridLayoutDemo() {
		super("GridLayout Demo");
		grid1 = new GridLayout(2, 4, 5, 5);// row, col, hgap, vgap
		grid2 = new GridLayout(4, 2);
		container = getContentPane();
		buttons = new JButton[names.length];
		for (int count = 0 ; count < names.length; count++) {
			buttons[count] = new JButton(names[count]);
			buttons[count].addActionListener(this);
			container.add(buttons[count]);
		}
		setSize(300, 150);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent event) {
		if (toggle) {
			container.setLayout(grid2);
		}
		else {
			container.setLayout(grid1);
		}
		toggle = !toggle;// whichever button down, the toggle will change value
		container.validate();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GridLayoutDemo app = new GridLayoutDemo();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
