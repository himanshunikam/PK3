import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

public class FirstWindow extends JFrame implements ActionListener {
	
	String element = "X";
	boolean computer_gegner = false;
	
	JRadioButton xButton;
	JRadioButton oButton;
	JRadioButton manuellButton;
	JRadioButton computerButton;
	
	ButtonGroup firstGroup;
	ButtonGroup secondGroup;
	
	JButton submit;
	
	JLabel label;
	JLabel label2;
	JLabel label3;
	
	
	JPanel panel1;
	JPanel panel2;
	JPanel panel3;
	JPanel panel4;
	JPanel panel5;
	JPanel panel6;
	
	FirstWindow(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(new Dimension(500,500));
		this.setLocationRelativeTo(null);
		
		label = new JLabel();
		label.setText("Tic Tac Toe");
		label.setOpaque(true);
		label.setFont(new Font(null, Font.BOLD, 40));
		
		label2 = new JLabel();
		label2.setText("Element Waehlen :");
		label2.setOpaque(true);
		label2.setFont(new Font(null, Font.BOLD, 25));
		
		label3 = new JLabel();
		label3.setText("Spieler Waehlen:");
		label3.setOpaque(true);
		label3.setFont(new Font(null, Font.BOLD, 25));
		
		panel1 = new JPanel();
		panel1.setBounds(0,0,500,50);
		panel1.add(label);
		
		panel2 = new JPanel();
		panel2.setBounds(0,50,250,200);
		panel2.add(label2);
		
		
		panel3 = new JPanel();
		panel3.setBounds(0,250,250,150);
		panel3.add(label3);
		
		panel4 = new JPanel();
		panel4.setBounds(0,400,500,50);
		
		
		
		
		panel5 = new JPanel();
		panel5.setBounds(250,50,250,200);
		
		
		panel6 = new JPanel();
		panel6.setBounds(250,250,250,150);
		
		
		xButton = new JRadioButton("X");
		oButton = new JRadioButton("O");
		
		xButton.addActionListener(this);
		oButton.addActionListener(this);
		
		firstGroup= new ButtonGroup();
		firstGroup.add(xButton);
		firstGroup.add(oButton);
		
		manuellButton = new JRadioButton("manuell");
		computerButton = new JRadioButton("computer");
		
		manuellButton.addActionListener(this);
		computerButton.addActionListener(this);
		
		secondGroup = new ButtonGroup();
		secondGroup.add(manuellButton);
		secondGroup.add(computerButton);
		
		panel5.add(xButton);
		panel5.add(oButton);
		
		panel6.add(manuellButton);
		panel6.add(computerButton);
		
		submit = new JButton("Submit");
		submit.setFocusable(false);
		submit.setPreferredSize(new Dimension(100,20));
		submit.setBounds(200, 450, 100, 20);
		submit.addActionListener(this);
		
		panel4.add(submit);
		
		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
		this.add(panel5);
		this.add(panel6);
		this.add(panel4);
		
		this.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==oButton) {
			this.element = "O";
		}
		if(e.getSource()==computerButton) {
			this.computer_gegner = true;
		}
		if(e.getSource()==submit) {
			MainWindow main = new MainWindow(this.element, this.computer_gegner);
			this.dispose();
		}
	}

}
