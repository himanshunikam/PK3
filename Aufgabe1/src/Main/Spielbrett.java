package Main;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Spielbrett {
	//Initialisierungen
	public char[][] spielbrett = new char[5][5];    
	public int[][] valid_position = new int[9][2]; //enthaelt koordinaten der aktuelle freie plaetze in das Spielbrett
    public boolean win = false;
    //enthaelt  ,,Position'' des freies platzes in das Spielbrett 
   //z.B. valid_position[0][0] hat den available_index 0 usw.
    public ArrayList<Integer> available_index = new ArrayList<Integer>();  
    public Spielbrett(){
    	//Erstellung des Spielbretts
        for (int i = 0; i < 5; i++) {
            if (i%2 == 0) {
                this.spielbrett[i][1] = this.spielbrett[i][3]='|';//Grenze
                this.spielbrett[i][0] = this.spielbrett[i][2]= this.spielbrett[i][4] = ' ';
            }
            else {
                this.spielbrett[i][0] = this.spielbrett[i][2]= this.spielbrett[i][4]='-';
                this.spielbrett[i][i] = this.spielbrett[1][3]= this.spielbrett[3][1]='+';
            }
        }
        int k = 0;
        //in valid_position werden freie plaetze hinzugefuegt
        for (int i = 0; i < spielbrett.length; i++) {
            for (int j = 0; j < spielbrett[i].length; j++) {
                if (spielbrett[i][j] == ' ' && k <=9) {
                    this.valid_position[k] = new int[]{i, j};
                    k++;
                }
            }
        }
      
        //Initialisierung von available_index 
        for (int i = 0; i < 9; i++) {
			this.available_index.add(i);
		}
    }
    
    public void print(){ //Um das Spielbrett auszudrucken
        for (int i = 0; i < 5; i++) {
            System.out.print('\n');
            for (int j = 0; j < 5; j++) {
                System.out.print(this.spielbrett[i][j]);
            }
        }
    }
    
    public void placeElement(char element, int x, int y){
    	
        if (this.spielbrett[x][y] == ' ') { 			//Prueft ob das platz freie ist.
            this.spielbrett[x][y] = element;			//Platziert das element
            System.out.println("\n\nElement placed");
            this.updateAvailableIndex(x, y);			//aktualisiert available_index
            this.print();
            if (this.check_win(element,x,y)) {			//Prueft fuer das gewinn zustand
                System.out.println("\nGame Over, "+element+" Wins");
            }
        }else {//TODO : try-catch 
            System.out.println("\nElement not placed");
            
        }
    }
    public void updateAvailableIndex(int x, int y){ 							//nimmt das index von position in valid_position
    	int valueToRemove = 0;													// z.B. spieler hat an der stelle 2,2 (mittlere box) element platziert	
    	for (int i = 0; i < this.valid_position.length; i++) {					// 2,2 liegt an der stelle 4 in valid_position
			if(this.valid_position[i][0]==x && this.valid_position[i][1]==y) {  // der wert 4 (nicht das index 4) wird von der available_index entfernt
				valueToRemove= i;
			}
		}
//	    	System.out.println("Value to Remove: "+ valueToRemove);
    	for (int i = 0; i < this.available_index.size(); i++) {
			if(this.available_index.get(i)==valueToRemove) {
				this.available_index.remove(i);
			}
		}
//	    	System.out.println("Available index has :" +Arrays.toString(this.available_index.toArray()));
//	    	System.out.println("\nAvailable index updated");
    }
    public boolean check_win(char element, int x, int y){  //check win methode, quelle :https://stackoverflow.com/a/1058804
        int col = 0;
        int row = 0;
        int diag =0;
        int rdiag =0;

        for (int i = 0; i < 5; i++) {
            if (this.spielbrett[x][i] == element) {
                col++;
            }
            if (this.spielbrett[i][y] == element) {
                row++;
            }
            if (this.spielbrett[i][i] == element) {
                diag++;
            }
            if (this.spielbrett[i][5-i-1] == element ) { 
                rdiag++;
            }
        }
        if (row == 3 || col == 3 || rdiag == 3 || diag == 3) {
            this.win = true;
        }
        return this.win;
    }
    public void start(Spieler spieler_1, Spieler spieler_2){  //Haupt start funktion
        try {
			if (spieler_1.element != spieler_2.element) {
				Scanner scanner = new Scanner(System.in);
				Spieler aktuell_spieler = spieler_1;
				Spieler aktuell_gegner = spieler_2;
				Spieler temp;
				this.print();
				while (!this.win) {
					aktuell_spieler.moveElement(this, aktuell_gegner);
					temp = aktuell_spieler;
					aktuell_spieler = aktuell_gegner;
					aktuell_gegner = temp;
				} 
			}else {
				throw new IllegalArgumentException();
			}
		} catch (Exception e) {
			System.out.println("Beide spieler haben die gleiche Elemente.");
		}

    }
}
