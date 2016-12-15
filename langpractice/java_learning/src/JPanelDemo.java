import java.util.Vector;
import javax.swing.*;

public class JPanelDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("JPanel eg");
		JPanel panel = new JPanel();
		panel.add(new JLabel("label"));
		panel.add(new JButton("Button"));
		panel.add(new JCheckBox("check box"));
		panel.add(new JRadioButton("Radio Button"));
		Vector<String> list = new Vector<String>();
		for (int i = 0; i < 5; i++) {
			list.add("" + i);
		}
		panel.add(new JComboBox(list));
		panel.add(new JTextArea("Here is JTextArea"));
		frame.add(panel);
		frame.pack();
		frame.setLocation(400, 400);
		frame.setVisible(true);
	}

}
