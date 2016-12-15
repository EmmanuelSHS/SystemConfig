import java.awt.*;
import javax.swing.*;

public class CardLayoutDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("CardLayout eg");
		CardLayout card = new CardLayout();
		frame.setLayout(card);
		Container cont = frame.getContentPane();
		for (int count = 1; count < 7; count++) {
			cont.add(new JLabel("Card" + count, JLabel.CENTER), String.valueOf(count));
		}
		frame.setSize(400, 400);
		frame.setVisible(true);
		card.show(cont, "1");
		for (int i = 0; i < 6; i++) {
			try {
				Thread.sleep(2000);
				card.next(cont);// loop, when card6 done, next is card1
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
