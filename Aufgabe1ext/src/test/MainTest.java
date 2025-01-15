package test;

import static org.junit.Assert.assertTrue;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Arrays;
import java.util.Iterator;
import javax.swing.JFrame;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Main.*;


public class MainTest {

	
	@BeforeEach
	public void setUp() {
		FirstWindow window = new FirstWindow();
		MainWindow mainWindow = new MainWindow("X", true);
	}
	
	@Test
	public void swingTest() {
		FirstWindow window = new FirstWindow();
		Assert.assertEquals(window.getWidth(), 500);
		Assert.assertEquals(window.getHeight(), 500);
		
		Assert.assertEquals(window.label.getText(), "Tic Tac Toe");
		Assert.assertEquals(window.label.getFont(), new Font(null, Font.BOLD, 40));
		Assert.assertEquals(window.label2.getText(), "Element Waehlen :");
		Assert.assertEquals(window.label2.getFont(), new Font(null, Font.BOLD, 25));
		Assert.assertEquals(window.label3.getText(), "Spieler Waehlen:");
		Assert.assertEquals(window.label3.getFont(), new Font(null, Font.BOLD, 25));
		
		Assert.assertEquals(window.panel1.getWidth(),500);
		Assert.assertEquals(window.panel1.getHeight(),50);
		Assert.assertEquals(window.panel2.getWidth(),250);
		Assert.assertEquals(window.panel2.getHeight(),200);
		Assert.assertEquals(window.panel3.getWidth(),250);
		Assert.assertEquals(window.panel3.getHeight(),150);
		Assert.assertEquals(window.panel4.getWidth(),500);
		Assert.assertEquals(window.panel4.getHeight(),50);
		Assert.assertEquals(window.panel5.getWidth(),250);
		Assert.assertEquals(window.panel5.getHeight(),200);
		Assert.assertEquals(window.panel6.getWidth(),250);
		Assert.assertEquals(window.panel6.getHeight(),150);
		
		Assert.assertEquals(window.xButton.getText(), "X");
		Assert.assertEquals(window.oButton.getText(), "O");
		Assert.assertEquals(window.manuellButton.getText(), "manuell");
		Assert.assertEquals(window.computerButton.getText(), "computer");
		Assert.assertEquals(window.submit.getText(), "Submit");
		Assert.assertEquals(window.submit.getPreferredSize(), new Dimension(100,20));
		
		MainWindow mainWindow = new MainWindow("X", true);
		Assert.assertEquals(mainWindow.element, "X");
		Assert.assertTrue(mainWindow.computer_gegner);
		Assert.assertEquals(mainWindow.getDefaultCloseOperation(), JFrame.EXIT_ON_CLOSE);
		Assert.assertEquals(mainWindow.getSize(), new Dimension(800,800));
		Assert.assertEquals(mainWindow.titelPanel.getWidth(), 800);
		Assert.assertEquals(mainWindow.titelPanel.getHeight(),100);
		Assert.assertEquals(mainWindow.titel.getText(), "Tic Tac Toe");
		Assert.assertEquals(mainWindow.titel.getBackground(), Color.gray);
		Assert.assertEquals(mainWindow.titel.getFont(), new Font(null, Font.BOLD, 25));
		
		for (int i = 0; i < 9; i++) {
			Assert.assertEquals(mainWindow.buttons[i].getText(), "");
			Assert.assertEquals(mainWindow.buttons[i].getFont(), new Font(null, Font.BOLD, 50));
		}
	}
	
	@Test
	public void spielBrettTest() {
		MainWindow mainWindow = new MainWindow("X", true);
		mainWindow.buttons[0].setText("X");
		mainWindow.buttons[1].setText("X");
		mainWindow.buttons[2].setText("X");
		mainWindow.buttons[3].setText("X");
		mainWindow.buttons[4].setText("X");
		mainWindow.buttons[5].setText("X");
		mainWindow.buttons[6].setText("X");
		mainWindow.buttons[7].setText("X");
		mainWindow.buttons[8].setText("X");
		
		Assert.assertEquals(mainWindow.getElement(0), "X");
		Assert.assertEquals(mainWindow.getElement(1), "X");
		Assert.assertEquals(mainWindow.getElement(2), "X");
		Assert.assertEquals(mainWindow.getElement(3), "X");
		Assert.assertEquals(mainWindow.getElement(4), "X");
		Assert.assertEquals(mainWindow.getElement(5), "X");
		Assert.assertEquals(mainWindow.getElement(6), "X");
		Assert.assertEquals(mainWindow.getElement(7), "X");
		Assert.assertEquals(mainWindow.getElement(8), "X");
	}
	
	@Test 
	public void checkWinTest() {
		MainWindow mainWindow = new MainWindow("X", true);
		mainWindow.buttons[0].setText("X");
		mainWindow.buttons[1].setText("X");
		mainWindow.buttons[2].setText("X");
		mainWindow.check(0, "X");
		Assert.assertTrue(mainWindow.win);
		
		mainWindow = new MainWindow("X", true);
		mainWindow.buttons[0].setText("X");
		mainWindow.buttons[3].setText("X");
		mainWindow.buttons[6].setText("X");
		mainWindow.check(0, "X");
		Assert.assertTrue(mainWindow.win);
		
		mainWindow = new MainWindow("X", true);
		mainWindow.buttons[0].setText("X");
		mainWindow.buttons[4].setText("X");
		mainWindow.buttons[8].setText("X");
		mainWindow.check(0, "X");
		Assert.assertTrue(mainWindow.win);
		
		mainWindow = new MainWindow("X", true);
		mainWindow.buttons[2].setText("X");
		mainWindow.buttons[4].setText("X");
		mainWindow.buttons[6].setText("X");
		mainWindow.check(2, "X");
		Assert.assertTrue(mainWindow.win);
	}
	
	@AfterEach
	public void tearDown() {
		FirstWindow window = new FirstWindow();
	}

}
