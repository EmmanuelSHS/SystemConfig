import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class JLabelDemo extends JFrame {
	private JLabel label1;
	public JLabelDemo() {
		super("JLable example");
		Font font = new Font("Dialog", Font.ITALIC + Font.BOLD, 30);
		Container container = getContentPane();
		container.setLayout( new FlowLayout() );
		label1 = new JLabel( "Label in forms of texts" );
		label1.setToolTipText( "label 1");// tips when mouse on it
		label1.setFont(font);// font is from Font font = new Font(xxx)
		container.add(label1);
		// Icon bug = new ImageIcon("img.jpg");
		// label1.setIcon(bug);
		label1.setHorizontalTextPosition(SwingConstants.CENTER);
		label1.setVerticalTextPosition(SwingConstants.BOTTOM);
		setSize(600, 300);//why container.xxx not necessary?
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JLabelDemo app = new JLabelDemo();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
