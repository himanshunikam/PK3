package swing.window;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class frame2 extends JFrame implements ActionListener{
	
	JCheckBox checkBox;
	JButton button;
	frame2(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		button = new JButton();
		button.setText("Submit");
		button.addActionListener(this);
		
		checkBox = new JCheckBox();
		checkBox.setText("I am not a Robot");
		checkBox.setFocusable(false);
		checkBox.setFont(new Font("Consolas", Font.PLAIN, 35));
		
		this.add(button);
		this.add(checkBox);
		this.pack();
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) {
			System.out.println(checkBox.isSelected());
		}
		
	}

}
