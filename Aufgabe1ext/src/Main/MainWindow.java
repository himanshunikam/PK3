package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.*;
import javax.swing.*;

public class MainWindow extends JFrame implements ActionListener {
	//Initialisierung von die elemente in die zweite Fenster
	
	//Default values
	public boolean win = false;
	public Random random = new Random();
	public boolean playerTurn = true;
	public String element;
	public String gegnerElement;
	public boolean computer_gegner;
	public ArrayList<Integer> available_buttons = new ArrayList<Integer>();
	
	public JButton[] buttons = new JButton[9];
	public JLabel titel = new JLabel();
	public JPanel titelPanel = new JPanel();
	public JPanel buttonPanel = new JPanel();
	
	
	
	public MainWindow(String element, boolean computer_gegner){
		this.element = element;
		this.computer_gegner = computer_gegner;
		this.gegnerElement = this.getGegnerElement();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(800,800));
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		
		titelPanel.setLayout(new BorderLayout());
		titelPanel.setBounds(0,0,800,100);
		
		titel.setText("Tic Tac Toe");
		titel.setBackground(Color.gray);
		titel.setFont(new Font(null, Font.BOLD, 25));
		titel.setOpaque(true);
		
		buttonPanel.setLayout(new GridLayout(3,3));
		//Erstellung von knoepfe 
		for(int i =0; i< 9; i++) {
			buttons[i] = new JButton("");
			buttonPanel.add(buttons[i]);
			buttons[i].addActionListener(this);
			buttons[i].setFocusable(false);
			buttons[i].setFont(new Font(null, Font.BOLD, 50));
			
			this.available_buttons.add(i);
		}
		
		titelPanel.add(titel);
		this.add(titelPanel, BorderLayout.NORTH);
		this.add(buttonPanel);
		
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) { //Haupt eingabe methode
		for(int i =0; i<9; i++) {
			if(e.getSource()==buttons[i] && buttons[i].getText()=="") { //wenn das knopf leer ist
				if(this.playerTurn) { //wenn der erster Spieler spielt
					playerSpielt(i);
				}
				else if(!this.computer_gegner) {  // wenn computer_gegner false ist, also wenn Gegner auch ein Person ist.
					gegnerSpielt(i);
				}
			}
		}
		if(this.computer_gegner && !this.playerTurn && this.available_buttons.size()>0 && !this.win) { //wenn compueter_gegner wahr ist
			computerSpielt();
		}
		
	}
	
	public void playerSpielt(int i) {
		buttons[i].setText(element); //button wird zu den entsprechenden Spieler element gesetzt.
		playerTurn = false;
		titel.setText(gegnerElement +" Turn");
		this.available_buttons.remove(getPosition(i)); //available_buttons wird aktualisiert
		check(i, element);
	}
	
	public void gegnerSpielt(int i) {
		buttons[i].setText(gegnerElement);
		this.available_buttons.remove(getPosition(i));
		playerTurn = true;
		titel.setText(element +" Turn");
		check(i,gegnerElement);
	}
	
	public void computerSpielt() {  //dieselbe logik von CompueterSpieler.java in Aufgabe1
		int randomButton = getRandomButton();
		buttons[randomButton].setText(gegnerElement);
		titel.setText(element+ "Turn");
		playerTurn = true;
		check(randomButton, gegnerElement);
	}
	public int getRandomButton() {
		int randomIdx = random.nextInt(this.available_buttons.size());
		int randomButton = this.available_buttons.get(randomIdx);
		System.out.println("randomIdx: "+ randomIdx);
		System.out.println("randomButton: "+randomButton);
		this.available_buttons.remove(randomIdx);
		System.out.println("Available Buttons size: "+this.available_buttons.size()+ '\n'+this.available_buttons.toString());
		return randomButton; 
	}
	private int getPosition(int k) { //gibt position zurueck in available_buttons
		for(int i =0; i<this.available_buttons.size(); i++) {
			if(this.available_buttons.get(i)==k) {
				return i;
			}
		}
		return -1;
	}
	public String getElement(int i) { //gibt element in den entsprechende Button zurueck.
		return buttons[i].getText();
	}
	private String getGegnerElement() { //gibt das gegner_element zurueck
		if(element == "X") {
			gegnerElement ="O";
		}
		else{
			gegnerElement="X";
		}
		return gegnerElement;
	}
	public int linearIdx(int x, int y) { //linear index fuer check_win
		return (x*3)+y;
	}
	public void check(int n, String element) {  //dieselbe check_win logik von Spielbrett.java in Aufgabe 1
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
			System.out.println("Win Condition reached!!!!");
			titel.setText(element+" Wins!");
			
		}else {
			if(this.available_buttons.size()==0) {
				wins();
				titel.setText("UNENTSCHIEDEN");
			}
		}
		
	}
	
	public void wins() {  // Setzt Gewinnzustand ein
		this.win = true;
		for(int i =0; i<9; i++) {
			buttons[i].setEnabled(false);
		}
	}

}
