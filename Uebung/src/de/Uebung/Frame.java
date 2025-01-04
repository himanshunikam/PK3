package de.Uebung;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Frame extends JFrame implements ActionListener {
		
	JRadioButton pizzaButton ;
	JRadioButton hamburgerButton;
	JRadioButton hotdogButton;
	ButtonGroup group;
	
	Frame(){
			
			this.setVisible(true);
			this.setSize(500,500);
			this.setTitle("JFrame Title");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setResizable(true);
			this.setLayout(new FlowLayout());
				
			pizzaButton = new JRadioButton("pizza");
			hamburgerButton = new JRadioButton("hamburger");
			hotdogButton = new JRadioButton("hotdog");
			
			group = new ButtonGroup();
			group.add(pizzaButton);
			group.add(hamburgerButton);
			group.add(hotdogButton);
			
			pizzaButton.addActionListener(this);
			hamburgerButton.addActionListener(this);
			hotdogButton.addActionListener(this);
			
			this.add(pizzaButton);
			this.add(hamburgerButton);
			this.add(hotdogButton);
			//ImageIcon image = new ImageIcon("path");
			//this.setIconImage(image.getImage());
			this.getContentPane().setBackground(Color.white);
			this.pack();
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==pizzaButton) {
				System.out.println("You ordered a Pizza");
			}else if(e.getSource()==hamburgerButton) {
				System.out.println("YOur ordered a Hamburger");
			}else if(e.getSource()==hotdogButton) {
				System.out.println("You ordered a Hotdog");
			}
			
		}
}
