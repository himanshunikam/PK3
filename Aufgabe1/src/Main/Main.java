package Main;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Spieler spieler_1 = new Person('X');
		Spieler spieler_2 = new Person('O');
		
		Spieler spieler_3 = new ComputerSpieler('O');
		
		Spielbrett spielbrett = new Spielbrett();
		//spieler_3 mit spieler_2 ersetzen fuer manuelle eingabe
		spielbrett.start(spieler_1, spieler_3);
		
	}

}
