package Main;
import java.util.Scanner;

//Klasse fuer ein Person spieler
public class Person extends Spieler{

	public Person(char element) {
		super(element);
		this.isComputer = false;
	}
	
	@Override
	public void moveElement(Spielbrett spielbrett, Spieler gegner){
        //TODO : Add a try loop
		Scanner scanner = new Scanner(System.in);
		System.out.print("\nPosition Eingeben (Eingabe bereich: von 1 bis 9): ");  
        int linearIdx = 0;         //nimmt das eingabe ein
		try {
			linearIdx = scanner.nextInt();
			
		} catch (Exception e) {
			System.out.println("Falsche Eingabe, nochmals versuchen: ");
			this.moveElement(spielbrett, gegner);
		}
        while (this.chance) {   // wandelt das ein-stellige Eingabe in die entsprechende kooridnaten in Spielbrett
            int xIdx = 0;
            int yIdx;
            try {
				if ((linearIdx==2 || linearIdx==5 || linearIdx==8)){
				    xIdx = 1;
				} else if (linearIdx==3 || linearIdx==6 || linearIdx==9){
				    xIdx = 2;
				} else if (linearIdx==1 || linearIdx==4 || linearIdx==7) {
				    xIdx =0;

				}else {
				    throw new IllegalArgumentException();
				}
			} catch (Exception e) {
				System.out.println("Falsche Eingabe, nochmals versuchen: ");
				this.moveElement(spielbrett, gegner);
			}
            
            yIdx = (linearIdx-(xIdx-1))/3;

            // Anpassungen da Spielbrett ,,Waende'' hat
            
            if (xIdx == 2) xIdx += 2;
            if (xIdx == 1) xIdx += 1;
            if (yIdx == 2) yIdx += 2;
            if (yIdx == 1 ) yIdx += 1;
         
            try {
				if (spielbrett.spielbrett[xIdx][yIdx] == ' ') {  //Prueft ob das position in das spielbrett frei ist.
					spielbrett.placeElement(this.element, xIdx, yIdx);
				}else {
					throw new IllegalArgumentException();
				}
			} catch (Exception e) {
				System.out.println("schon besetzt, wider versuchen: ");
				this.moveElement(spielbrett, gegner);
			}
            
            this.chance = false;
            gegner.chance = true;
        }
    
    }

}
