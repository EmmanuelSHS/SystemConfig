import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Random;
import javax.swing.*;

public class CommonStatisticDistribution extends JFrame {
	private int totnum;
	private double upper;
	private double lower;
	private String filename;
	private String disname;
	
	private JButton Random, Gaussian;
	private JLabel JTLabel, JLLabel, JULabel, JFLabel, JPicWindow;
	private Icon home, ran, gau;
	private JTextField JTotnum, JLower, JUpper, JFilename;
	private JPanel JPicture, JSelection, JParameter;

	private void generRand() throws IOException {
		Random r = new Random();
		
		File outputfile = new File(filename);
		if (outputfile.exists()) {
			outputfile.delete();
			//System.out.println("delete " + outputfile.delete());
		}
		outputfile.createNewFile();
		FileWriter fw = new FileWriter(outputfile);
		
		switch (disname) {
		case "Random":
			/** ? */
			//System.out.println(totnum);
			for (int i = 0; i < totnum; ++i) {
				double tmpnum = r.nextDouble() * (upper - lower) + lower;
				//System.out.println(tmpnum);
				fw.write(Double.toString(tmpnum) + "\r");
				//System.out.println("1");
			};
			//System.out.println("2");
		case "Gaussian":
			for (int i = 0; i < totnum; ++i) {
				double tmpnum = r.nextGaussian() + (upper - lower)/2;
				fw.write(Double.toString(tmpnum) + "\r");
			};
		//writer.close();
		fw.close();
		}
	}
	
	private void picSet() {
		if (disname == "Gaussian") {
			JPicWindow.setIcon(gau);
		}
		else if (disname == "Random") {
			JPicWindow.setIcon(ran);
		}
	}

	public CommonStatisticDistribution() {
		totnum = 100;
		upper = 0.;
		lower = 1.;
		filename = "output.txt";
		disname = "Random";
		
		setTitle("Distribution Generator");
		JPicture = new JPanel();
		JSelection = new JPanel();
		JParameter = new JPanel();
		JPicture.setLayout(new FlowLayout());
		JPicture.setSize(600, 400);
		JSelection.setLayout(new FlowLayout());
		JSelection.setSize(600, 20);
		JParameter.setLayout(new GridLayout(4, 2));
		JParameter.setSize(600, 180);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(JPicture, BorderLayout.NORTH);
		getContentPane().add(JParameter, BorderLayout.CENTER);
		getContentPane().add(JSelection, BorderLayout.SOUTH);
		
		JSelection.add(Random = new JButton("Random"));
		JSelection.add(Gaussian = new JButton("Gaussian"));
		
		JTLabel = new JLabel("Random Numbers #");
		JLLabel = new JLabel("Lower Boundary");
		JULabel = new JLabel("Upper Boundary");
		JFLabel = new JLabel("Output File names");
		JTotnum = new JTextField("100", 10);
		JLower = new JTextField("0", 10);
		JUpper = new JTextField("1", 10);
		JFilename = new JTextField("output.txt", 20);
		
		JParameter.add(JTLabel);
		JParameter.add(JTotnum);
		JParameter.add(JLLabel);
		JParameter.add(JLower);
		JParameter.add(JULabel);
		JParameter.add(JUpper);
		JParameter.add(JFLabel);
		JParameter.add(JFilename);
		
		home = new ImageIcon("distribution.png");
		gau = new ImageIcon("gaussian.jpg");
		ran = new ImageIcon("uniform.jpg");
		
		JPicWindow = new JLabel(home);
		JPicture.add(JPicWindow);
		
		Handler handler = new Handler();
		Random.addActionListener(handler);
		Gaussian.addActionListener(handler);
		
		setSize(600,400);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private class Handler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			disname = e.getActionCommand();

			totnum = Integer.parseInt(JTotnum.getText());
			lower = Double.parseDouble(JLower.getText());
			upper = Double.parseDouble(JUpper.getText());
			filename = JFilename.getText();
			try {
				generRand();
				//System.out.println(disname);
				picSet();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		CommonStatisticDistribution csd = new CommonStatisticDistribution();
	}

}
