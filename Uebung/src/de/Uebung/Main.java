package de.Uebung;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

//https://youtu.be/Kmgo00avvEw?si=UvtlXzHPQ7oHWGf9


public class Main {

	public static void main(String[] args) {
		UebungSwing spiel= new UebungSwing();
		
		//Frame frame = new Frame();
		new MyFrame();
		/*
		Border border = BorderFactory.createLineBorder(Color.green,3);
		
		JLabel label = new JLabel();
		label.setText("Himanshu Nikam");
		label.setForeground(Color.red);
		label.setFont(new Font("MV Boli", Font.PLAIN, 50));
		label.setBackground(Color.black);
		label.setOpaque(true);
		label.setBorder(border);
		label.setVerticalAlignment(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		//label.setBounds(100,100,250,250);
		//frame.add(label);
		
		JLabel label2= new JLabel();
		label2.setText("HI");
		label2.setVerticalAlignment(JLabel.BOTTOM);
		label2.setHorizontalAlignment(JLabel.RIGHT);
		label2.setBounds(100,100,75,75);
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		
		panel1.setBackground(Color.red);
		panel2.setBackground(Color.green);
		panel3.setBackground(Color.yellow);
		panel4.setBackground(Color.magenta);
		panel5.setBackground(Color.blue);
		
		panel1.setPreferredSize(new Dimension(100,100));
		panel2.setPreferredSize(new Dimension(100,100));
		panel3.setPreferredSize(new Dimension(100,100));
		panel4.setPreferredSize(new Dimension(100,100));
		panel5.setPreferredSize(new Dimension(100,100));
	
//-----------SUB PANELS----------------------------------------------------
		JPanel panel6 = new JPanel();
		JPanel panel7 = new JPanel();
		JPanel panel8 = new JPanel();
		JPanel panel9 = new JPanel();
		JPanel panel10 = new JPanel();
		
		panel6.setBackground(Color.black);
		panel7.setBackground(Color.darkGray);
		panel8.setBackground(Color.gray);
		panel9.setBackground(Color.lightGray);
		panel10.setBackground(Color.white);
		
		panel5.setLayout(new BorderLayout());
		
		panel6.setPreferredSize(new Dimension(50,50));
		panel7.setPreferredSize(new Dimension(50,50));
		panel8.setPreferredSize(new Dimension(50,50));
		panel9.setPreferredSize(new Dimension(50,50));
		panel10.setPreferredSize(new Dimension(50,50));
		
		panel5.add(panel6, BorderLayout.NORTH);
		panel5.add(panel7, BorderLayout.SOUTH);
		panel5.add(panel8, BorderLayout.WEST);
		panel5.add(panel9, BorderLayout.EAST);
		panel5.add(panel10, BorderLayout.CENTER);
//-------------SUB PANELS---------------------------------------------------
		
		//frame.add(panel1, BorderLayout.NORTH);
		//frame.add(panel2, BorderLayout.WEST);
		//frame.add(panel3, BorderLayout.EAST);
		//frame.add(panel4, BorderLayout.SOUTH);
		//frame.add(panel5, BorderLayout.CENTER);
		
//#############################################################################################################################
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(100,250));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setLayout(new FlowLayout());
		
		panel.add(new JButton("1"));
		panel.add(new JButton("2"));
		panel.add(new JButton("3"));
		panel.add(new JButton("4"));
		panel.add(new JButton("5"));
		panel.add(new JButton("6"));
		panel.add(new JButton("7"));
		panel.add(new JButton("8"));
		panel.add(new JButton("9"));
		//frame.add(panel);
//##########################################################################################################################################
		
		frame.add(new JButton("1"));
		frame.add(new JButton("2"));
		frame.add(new JButton("3"));
		frame.add(new JButton("4"));
		frame.add(new JButton("5"));
		frame.add(new JButton("6"));
		frame.add(new JButton("7"));
		frame.add(new JButton("8"));
		frame.add(new JButton("9"));
		frame.add(new JButton("10"));
		
//###############################################################################################################################################
		JLabel label1 = new JLabel();
		label1.setOpaque(true);
		label1.setBackground(Color.red);
		label1.setBounds(50,50,200,200);
		
		JLabel label2 = new JLabel();
		label2.setOpaque(true);
		label2.setBackground(Color.green);
		label2.setBounds(100,100,200,200);
		
		JLabel label3 = new JLabel();
		label3.setOpaque(true);
		label3.setBackground(Color.blue);
		label3.setBounds(150,150,200,200);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0,0,500,500);
		
		layeredPane.add(label1, Integer.valueOf(0));
		layeredPane.add(label2, Integer.valueOf(2));
		layeredPane.add(label3, Integer.valueOf(1));
		
		frame.add(layeredPane);
		
//###############################################################################################################################################
		
		//JOptionPane.showMessageDialog(null, "Hello", "Title", JOptionPane.PLAIN_MESSAGE);
		//JOptionPane.showMessageDialog(null, "Information Message", "Title", JOptionPane.INFORMATION_MESSAGE);
		//JOptionPane.showMessageDialog(null, "Question Message", "Title", JOptionPane.QUESTION_MESSAGE);
		//JOptionPane.showMessageDialog(null, "Warning Message", "Title", JOptionPane.WARNING_MESSAGE);
		//JOptionPane.showMessageDialog(null, "Error Message", "Title", JOptionPane.ERROR_MESSAGE);
		
		//int answer = JOptionPane.showConfirmDialog(null, "show confirm dialog", "Title", JOptionPane.YES_NO_CANCEL_OPTION);
		
		//String name = JOptionPane.showInputDialog("What is your name?");
		String[] responses = {"No, You are Awesone", "Thank You", "*blush*"};
		JOptionPane.showOptionDialog(null, 
				"You are awesone", 
				"scret message", 
				JOptionPane.YES_NO_CANCEL_OPTION, 
				JOptionPane.INFORMATION_MESSAGE, 
				null, 
				responses, 
				0);*/
//######################################################################################################################################################################
		
		
	}

}
