import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.*;
import javax.swing.*;

public class MainWindow extends JFrame implements ActionListener {
	boolean win = false;
	Random random = new Random();
	boolean playerTurn = true;
	String element;
	String gegnerElement;
	boolean computer_gegner;
	ArrayList<Integer> available_buttons = new ArrayList<Integer>();
	
	JButton[] buttons = new JButton[9];
	JLabel titel = new JLabel();
	JPanel titelPanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	
	
	
	MainWindow(String element, boolean computer_gegner){
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
	public void actionPerformed(ActionEvent e) {
		System.out.println("Available buttons size 0 iteration : "+ this.available_buttons.size()+ '\n'+this.available_buttons.toString());;
		for(int i =0; i<9; i++) {
			if(e.getSource()==buttons[i] && buttons[i].getText()=="") {
				if(this.playerTurn) {
					playerSpielt(i);
				}
				else if(!this.computer_gegner) {
					gegnerSpielt(i);
				}
			}
		}
		if(this.computer_gegner && !this.playerTurn && this.available_buttons.size()>0 && !this.win) {
			computerSpielt();
		}
		
	}
	
	public void playerSpielt(int i) {
		buttons[i].setText(element);
		playerTurn = false;
		titel.setText(gegnerElement +" Turn");
		//int choosenButton = this.available_buttons.get(i);
		System.out.println("i: "+ i);
		System.out.println("Removed element at position: "+getPosition(i));
		this.available_buttons.remove(getPosition(i));
		System.out.println("Available Buttons size after playerTurn: "+this.available_buttons.size()+ '\n'+this.available_buttons.toString());
		check(i, element);
	}
	
	public void gegnerSpielt(int i) {
		buttons[i].setText(gegnerElement);
		this.available_buttons.remove(getPosition(i));
		playerTurn = true;
		titel.setText(element +" Turn");
		check(i,gegnerElement);
	}
	
	public void computerSpielt() {
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
	private int getPosition(int k) {
		for(int i =0; i<this.available_buttons.size(); i++) {
			if(this.available_buttons.get(i)==k) {
				return i;
			}
		}
		return -1;
	}
	public String getElement(int i) {
		return buttons[i].getText();
	}
	private String getGegnerElement() {
		if(element == "X") {
			gegnerElement ="O";
		}
		else{
			gegnerElement="X";
		}
		return gegnerElement;
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
			System.out.println("Win Condition reached!!!!");
			titel.setText(element+" Wins!");
			/*try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.dispose();*/
			
		}else {
			if(this.available_buttons.size()==0) {
				wins();
				titel.setText("UNENTSCHIEDEN");
			}
		}
		
	}
	
	public void wins() {
		this.win = true;
		for(int i =0; i<9; i++) {
			buttons[i].setEnabled(false);
		}
	}

}
