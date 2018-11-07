import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.UIManager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class factor extends JFrame{
	private JPanel mainPanel = new JPanel();
	private JPanel inputPanel = new JPanel();
	
	public factor() {
		initGUI();
		
		setTitle("Factoring Machine");
		setSize(400, 200); //pixels
		setResizable(true);
		pack();
		setLocationRelativeTo(null); //centers on screen, do this after packing but before visible

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void initGUI() {
		// TODO Auto-generated method stub
		//title panel
		JPanel titlePanel = new JPanel();
		add(titlePanel, BorderLayout.PAGE_START);
		titlePanel.setBackground(Color.BLACK);			
		JLabel titleLabel = new JLabel("Factoring Machine");
		titlePanel.add(titleLabel);
		titleLabel.setHorizontalAlignment(JLabel.CENTER); //left or right
		Font titleFont = new Font("Arial", Font.BOLD, 50);			
		titleLabel.setForeground(Color.ORANGE);
		titleLabel.setFont(titleFont);
				
		//center panel
		JPanel centerPanel = new JPanel();
		add(centerPanel, BorderLayout.CENTER);
		centerPanel.setBackground(Color.RED);
		//first input box
		JLabel labelName = new JLabel("Input Coefficient of First Term:");
		JTextField factorInput1 = new JTextField(20);
        labelName.setLabelFor(factorInput1);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS));
        centerPanel.add(labelName);
        centerPanel.add(factorInput1);
        	//second input box
        JLabel labelName2 = new JLabel("Input Coefficient of the Second Term:");
		JTextField factorInput2 = new JTextField(20);
        labelName2.setLabelFor(factorInput2);
        centerPanel.add(labelName2);
        centerPanel.add(factorInput2);
        //third input box
        JLabel labelName3 = new JLabel("Input Final Constant Term:");
		JTextField factorInput3 = new JTextField(20);
        labelName3.setLabelFor(factorInput3);
        centerPanel.add(labelName3);
        centerPanel.add(factorInput3);
		
		//bottom panel
		JPanel bottomPanel = new JPanel();
		add(bottomPanel, BorderLayout.PAGE_END);
		bottomPanel.setBackground(Color.PINK);
		
		//buttons
		Font buttonFont = new Font("Arial", Font.BOLD, 25);
				
		JButton factorButton = new JButton("Factor");
		factorButton.setFont(buttonFont);;
		factorButton.setBackground(Color.RED);
				
		factorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					// this is the only thing that will change between buttons
				String strFactorInput1 = factorInput1.getText();
				double initialCoef = Double.parseDouble(strFactorInput1);
				String strFactorInput2 = factorInput2.getText();
				double initialCoef2 = Double.parseDouble(strFactorInput2);
				String strFactorInput3 = factorInput3.getText();
				double initialCoef3 = Double.parseDouble(strFactorInput3);
				double array1[] = quadEqn(initialCoef,initialCoef2,initialCoef3);
				}
			});
				
				bottomPanel.add(factorButton);
	}

	public static void main(String[] args) {
		try {
            String className = UIManager.getCrossPlatformLookAndFeelClassName();
            UIManager.setLookAndFeel(className);
        } catch ( Exception e) {}
        
        EventQueue.invokeLater(new Runnable (){
            @Override
            public void run() {
                new factor();
            }   
        });
		// TODO Auto-generated method stub

	}
	public static double[] quadEqn(double a, double b, double c) {
		double array1[] = new double [2];
		if ((b*b-4*a*c)== 0) {
			array1[0]= (-1* b + Math.sqrt(b*b-4*a*c))/(2*a);
			array1[1]= (-1* b - Math.sqrt(b*b-4*a*c))/(2*a);
		}
		if ((b*b-4*a*c)> 0) {
			array1[0]= (-1* b + Math.sqrt(b*b-4*a*c))/(2*a);
			array1[1]= (-1* b - Math.sqrt(b*b-4*a*c))/(2*a);
			JOptionPane.showMessageDialog(null, "x= " + array1[0]+ " and x= " + array1[1]);
		}
		if ((b*b-4*a*c)< 0) {
			JOptionPane.showMessageDialog(null, "There are no real roots");
		}
		return array1;
	}
}
