package de.Uebung;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

public class MyFrame extends JFrame implements ActionListener{
	
	JButton button;
	JLabel label;
	
	MyFrame(){
		ImageIcon icon = new ImageIcon("C:\\Users\\nikam\\eclipse-workspace\\Uebung\\src\\SAP.jpg");
		
		label = new JLabel();
		label.setIcon(icon);
		label.setBounds(150,250,150,150);
		label.setVisible(false);
		
		button = new JButton();
		button.setBounds(100,100,250,100);
		button.addActionListener(this);
		button.setText("I am a button");
		button.setFocusable(false);
		button.setFont(new Font("Comic Sans", Font.BOLD, 25));
		button.setForeground(Color.cyan);
		button.setBackground(Color.LIGHT_GRAY);
		button.setBorder(BorderFactory.createEtchedBorder());
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(500,500);
		this.setVisible(true);
		this.add(button);
		this.add(label);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) {
			System.out.println("HI");
			label.setVisible(true);
			//button.setEnabled(false);
		}
		
	}

	
	
}
