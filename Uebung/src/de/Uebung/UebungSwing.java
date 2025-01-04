package de.Uebung;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class UebungSwing implements ActionListener{
	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel title_panel = new JPanel();
	JPanel button_panel = new JPanel();
	JLabel textfield = new JLabel();
	JButton[] buttons = new JButton[9];
	boolean player1_turn;
	
	UebungSwing(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.getContentPane().setBackground(Color.white);	
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		textfield.setBackground(Color.black);
		textfield.setForeground(Color.green);
		textfield.setFont(new Font("Ink Free", Font.BOLD, 75));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("Tic-Tac-Toe");
		textfield.setOpaque(true);
		
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0, 0, 800, 100);
		
		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(Color.red);
		
		for(int i = 0; i<9; i++) {
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		
		title_panel.add(textfield);
		frame.add(title_panel, BorderLayout.NORTH);
		frame.add(button_panel);
		
		firstTurn();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String element;
		for(int i =0; i<9; i++) {
			if(e.getSource()==buttons[i]) {
				if(player1_turn) {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(Color.BLUE);
						element = "X";
						buttons[i].setText(element);
						player1_turn = false;
						textfield.setText("O turn");
						check(i, element);
					}
				}else {
					if(buttons[i].getText()=="") {
						element ="O";
						buttons[i].setForeground(Color.yellow);
						buttons[i].setText(element);
						player1_turn = true;
						textfield.setText("X turn");
						check(i, element);
					}
				}
			}
		}
		
	}
	public void firstTurn() {
		
		if(random.nextInt(2)==0) {
			player1_turn = true;
			textfield.setText("X turn");
		}else {
			player1_turn = false;
			textfield.setText("O turn");
		}
		
		
	}
	
	public int linearIdx(int x, int y) {
		return (x*3)+y;
	}
	public void check(int n, String element) {
		int row=0;
		int col =0;
		int diag =0;
		int rdiag=0;
		
		int x = (int) Math.floor(n/3);
		int y = n%3;
		
		for(int i=0; i<3; i++) {
			if(buttons[linearIdx(x,i)].getText() == element) {
				col++;
			}
			if(buttons[linearIdx(i,y)].getText()== element) {
				row++;
			}
			if(buttons[linearIdx(i,i)].getText()== element) {
				diag++;
		
			}
			if(buttons[linearIdx(i,3-i-1)].getText()==element) {
				rdiag++;
				System.out.println("Counted: "+ linearIdx(i,3-i-1));
				System.out.println("rdiag for "+ element+ ": "+rdiag);
			}
		}
		if(row==3 || col == 3 || diag==3|| rdiag==3) {
			wins();
			textfield.setText(element+" Wins!");
		}
		
	}
	
	public void wins() {
		for(int i =0; i<9; i++) {
			buttons[i].setEnabled(false);
		}
	}
	
	
}
