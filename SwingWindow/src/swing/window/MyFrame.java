package swing.window;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener{
	
	JButton button;
	JTextField textField;
	
	MyFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		button = new JButton("Submit");
		button.addActionListener(this);
		
		textField = new JTextField();
		textField.setPreferredSize(new Dimension(250,40));
		textField.setFont(new Font("Consolas", Font.PLAIN, 35));
		textField.setForeground(Color.green);
		textField.setBackground(Color.gray);
		textField.setCaretColor(Color.black);
		textField.setText("Username");
		
		
		this.add(textField);
		this.add(button);
		this.pack();
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) {
			System.out.println(textField.getText());
			button.setEnabled(false);
			textField.setEditable(false);
		}
		
	}

}
