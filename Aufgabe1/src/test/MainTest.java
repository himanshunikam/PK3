package test;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Main.ComputerSpieler;
import Main.Person;
import Main.Spielbrett;
import Main.Spieler;

public class MainTest {
	private static Spieler spieler1;
	private static Spieler spieler2;
	private static Spieler spieler3;
	private static Spielbrett spielbrett;
	
	@BeforeEach
	public void setUp() {
		spieler1 = new Person('X');
		spieler2 = new Person('O');
		spieler3 = new ComputerSpieler('O');
		spielbrett = new Spielbrett();
	}
	
	private boolean inAvailableIndex(int i, Spielbrett spielbrett) {
		for (int j = 0; j < spielbrett.available_index.size(); j++) {
			if (spielbrett.available_index.get(j)==i) {
				return true;
			}
		}
		return false;
	}
	
	@Test
	public void validElementTest() {
//		System.out.println("test running");
		Assert.assertTrue(spieler1.isValidElement('X'));
		Assert.assertTrue(spieler1.isValidElement('x'));
		Assert.assertTrue(spieler1.isValidElement('O'));
		Assert.assertTrue(spieler1.isValidElement('o'));
		Assert.assertFalse(spieler1.isValidElement('p'));
		Assert.assertFalse(spieler1.isValidElement('q'));
		Assert.assertFalse(spieler1.isValidElement('r'));
		Assert.assertFalse(spieler1.isValidElement('s'));
	}
	
	@Test
	public void spielbrettTest() {
		System.out.println(Arrays.deepToString(spielbrett.valid_position));
		spielbrett.placeElement('X', 0, 0);
		spielbrett.placeElement('X', 0, 2);
		spielbrett.placeElement('X', 0, 4);
		spielbrett.placeElement('X', 2, 0);
		spielbrett.placeElement('X', 2, 2);
		spielbrett.placeElement('X', 2, 4);
		spielbrett.placeElement('X', 4, 0);
		spielbrett.placeElement('X', 4, 2);
		spielbrett.placeElement('X', 4, 4);
		Assert.assertEquals(spielbrett.spielbrett[0][0], 'X');
		Assert.assertEquals(spielbrett.spielbrett[0][2], 'X');
		Assert.assertEquals(spielbrett.spielbrett[0][4], 'X');
		Assert.assertEquals(spielbrett.spielbrett[2][0], 'X');
		Assert.assertEquals(spielbrett.spielbrett[2][2], 'X');
		Assert.assertEquals(spielbrett.spielbrett[2][4], 'X');
		Assert.assertEquals(spielbrett.spielbrett[4][0], 'X');
		Assert.assertEquals(spielbrett.spielbrett[4][2], 'X');
		Assert.assertEquals(spielbrett.spielbrett[4][4], 'X');
	}
	
	@Test
	public void checkWinTest() {
		spielbrett.placeElement('X', 0, 0);
		spielbrett.placeElement('X', 0, 2);
		spielbrett.placeElement('X', 0, 4);
		Assert.assertTrue(spielbrett.win);
		spielbrett = new Spielbrett();
		spielbrett.placeElement('X', 0, 0);
		spielbrett.placeElement('X', 2, 0);
		spielbrett.placeElement('X', 4, 0);
		Assert.assertTrue(spielbrett.win);
		spielbrett = new Spielbrett();
		spielbrett.placeElement('X', 0, 0);
		spielbrett.placeElement('X', 2, 2);
		spielbrett.placeElement('X', 4, 4);
		Assert.assertTrue(spielbrett.win);
		spielbrett = new Spielbrett();
		spielbrett.placeElement('X', 0, 4);
		spielbrett.placeElement('X', 2, 2);
		spielbrett.placeElement('X', 4, 0);
		Assert.assertTrue(spielbrett.win);
	}
	@Test
	public void validInputTest() {
		Spielbrett spielbrett2 = new Spielbrett();
		spielbrett2.placeElement('X', 0, 0);
		spielbrett2.placeElement('O', 0, 0);
		Assert.assertEquals(spielbrett2.spielbrett[0][0], 'X');
	}
	@Test
	public void computerSpielerTest() {
		Spieler computer = new ComputerSpieler('X');
		Spieler gegner = new Person('O');
		Spielbrett spielbrettComputer = new Spielbrett();
		int initial_freie_plaetze = spielbrettComputer.available_index.size();
		computer.moveElement(spielbrettComputer, gegner);
		int final_freie_plaetze = spielbrettComputer.available_index.size();
		
		Assert.assertTrue(gegner.chance);
		Assert.assertFalse(computer.chance);
		Assert.assertEquals(1,initial_freie_plaetze- final_freie_plaetze);
	}
	
	@Test
	public void availableIndexTest() {
		spielbrett.placeElement('X', 0, 0);
		Assert.assertFalse(this.inAvailableIndex(0, spielbrett));
		for (int i = 1; i < 9; i++) {
			Assert.assertTrue(this.inAvailableIndex(i, spielbrett));
		}
	}
	@AfterEach
	public void clearBrett() {
		spielbrett = new Spielbrett();
	}
}
