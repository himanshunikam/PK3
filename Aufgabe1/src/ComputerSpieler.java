import java.util.Random;

public class ComputerSpieler extends Spieler {
	Random random = new Random();
	public ComputerSpieler(char element) {
		super(element);
		this.isComputer = true;
	}
	
	@Override
	public void moveElement(Spielbrett spielbrett, Spieler gegner) {
		if (this.chance) {
			int randomIdx = random.nextInt(spielbrett.available_index.size());
			int spielbrettIdx = spielbrett.available_index.get(randomIdx);
			int spielbrettPosX = spielbrett.valid_position[spielbrettIdx][0];
			int spielbrettPosY = spielbrett.valid_position[spielbrettIdx][1];
			System.out.println("Choosen elements: X: "+ spielbrettPosX+ " Y: "+spielbrettPosY);
			spielbrett.placeElement(this.element, spielbrettPosX, spielbrettPosY);
			this.chance = false;
			gegner.chance = true;
		}
		
	}
}
