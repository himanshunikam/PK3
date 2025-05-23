package Main;
import java.util.Random;
//Klasse fuer das Computer Spieler
public class ComputerSpieler extends Spieler {
	Random random = new Random();
	public ComputerSpieler(char element) {
		super(element);
		this.isComputer = true;
	}
	
	@Override
	public void moveElement(Spielbrett spielbrett, Spieler gegner) {
		if (this.chance) {
			int randomIdx = random.nextInt(spielbrett.available_index.size()); 				 	// waehlt ein zufaellige index in available_index
			int spielbrett_idx = spielbrett.available_index.get(randomIdx);						//nimmt das entsprechende element in available_index
			int spielbrett_posX = spielbrett.valid_position[spielbrett_idx][0];					// nimmt die entsprechende koordinaten in valid_position
			int spielbrett_posY = spielbrett.valid_position[spielbrett_idx][1];					//z.B. available_index == [0,2,5]
			System.out.println("Choosen elements: X: "+ spielbrett_posX+ " Y: "+spielbrett_posY); //randomIdx nimmt 3, spielbrettIdx ist dann 5
			spielbrett.placeElement(this.element, spielbrett_posX, spielbrett_posY);				//spielbrettPosx und spielbrett_posy nehmen die 5te element in valid_postion
			this.chance = false;
			gegner.chance = true;
		}
		
	}
}
