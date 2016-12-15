/**
 * KeyListener: keyPressed() keyReleased() keyTyped()
 * KeyEvent: getKeyChar() getKeyCode() getKeyText(int keyCode)
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyEventDemo extends JFrame implements KeyListener {
	private String line1 = "", line2 = "";
	private String line3 = "";
	private JTextArea textArea;
	public KeyEventDemo() {
		super("KeyEventDemo");
		textArea = new JTextArea(10, 15);
		textArea.setText("please press any key");
		textArea.setEnabled(false);
		getContentPane().add(textArea);
		addKeyListener(this);
		setSize(350, 100);
		setVisible(true);
	}
	public void keyPressed(KeyEvent event) {
		line1 = "pressed: " + event.getKeyText(event.getKeyCode());
		setLines2and3(event);
	}
	/** adaptor? */
	public void keyReleased(KeyEvent event) {
		line1 = "released: " + event.getKeyText(event.getKeyCode());
		setLines2and3(event);
	}
	public void keyTyped(KeyEvent event) {
		/** ?keyTyped = clicked + released */
		line1 = "typed: " + event.getKeyChar();
		setLines2and3(event);
	}
	private void setLines2and3(KeyEvent event) {
		line2 = "this is " + (event.isActionKey() ? "": "not ")
				+ "in action";
		/** ?is.action(): action key is a kind of keys */
		String temp = event.getKeyModifiersText(event.getModifiers());
		/**
		 * ?getKeyModifiersText(): modifiers are a type of keys
		 * ?getModifiers(): return modifiers parameters
		 */
		line3 = "entered combined keys " + (temp.equals("") ? "none" : temp);
		textArea.setText(line1 + "\n" + line2 + "\n" + line3 + "\n");
	}
	public static void main(String[] args) {
		KeyEventDemo app = new KeyEventDemo();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
