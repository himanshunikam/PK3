package swing.window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaunchPage implements ActionListener {
	
	JFrame frame = new JFrame();
	JButton myButton = new JButton("New Window");
	
	
	LaunchPage(){
		
		myButton.setBounds(100,160,200,40);
		myButton.setFocusable(false);
		myButton.addActionListener(this);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,400);
		frame.setLayout(null);
		frame.setVisible(true);
		
		frame.add(myButton);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == myButton) {
			frame.dispose();
			NewWindow myWindow = new NewWindow();
		}
		
	}
}
