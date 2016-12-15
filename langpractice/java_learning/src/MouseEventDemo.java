/**
 * common mmbrs:
 * MouseListener: mouseClicked() mousePressed() mouseReleased()
 * mouseEntered() mouseExited() 
 * MouseMotionListener: mouseDragged() mouseMoved()
 * MouseEvent: getX() getY()
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseEventDemo extends JFrame
implements MouseListener, MouseMotionListener {
	private JLabel statusBar;
	public MouseEventDemo() {
		super("MouseEvent eg");
		statusBar = new JLabel();
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(statusBar, BorderLayout.SOUTH);
		addMouseListener(this);
		addMouseMotionListener(this);
		setSize(275, 100);
		setVisible(true);
	}
	public void mouseClicked(MouseEvent event) {
		statusBar.setText("clicked at " + event.getX()
				+ ", " + event.getY());
	}
	public void mousePressed(MouseEvent event) {
		statusBar.setText("pressed at " + event.getX()
				+ ", " + event.getY());
	}
	public void mouseReleased(MouseEvent event) {
		statusBar.setText("released at " + event.getX()
				+ ", " + event.getY());
	}
	public void mouseEntered(MouseEvent event) {
		JOptionPane.showMessageDialog(null, "mouse entered");
	}
	public void mouseExited(MouseEvent event) {
		statusBar.setText("outside window ");
	}
	public void mouseDragged(MouseEvent event) {
		statusBar.setText("dragged through " + event.getX()
				+ ", " + event.getY());
	}
	public void mouseMoved(MouseEvent event) {
		statusBar.setText("moved to " + event.getX()
				+ ", " + event.getY());
	}
	public static void main(String[] args) {
		MouseEventDemo app = new MouseEventDemo();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
