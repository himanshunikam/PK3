// Quelle : https://de.wikipedia.org/wiki/Sieb_des_Eratosthenes
package Main;

import java.util.ArrayList;
import java.util.List;

public class siebEratosthenes extends siebThreader{
	public siebEratosthenes(int untere, int obere, int nummer, List<Long> ergebnis) {
		super(untere, obere, nummer, ergebnis);
		// TODO Auto-generated constructor stub
	}
	int untere; //Untere Grenze
	int obere;// Obere Grenze
	int thread_nummer;//Nummer des Threads
	List<Long> ergebnis;//Liste zur speicherung der Ergebnisse
	
	// Statische Methode zur Implementierung des Siebs des Eratosthenes
	// Berechnet Primzahlen im Bereich von `untere` bis `obere`
	public ArrayList<Long> primeChecker(int untere, int obere) {
		int n = obere- untere;
		ArrayList<Long> ausgabe = new ArrayList<Long>();
		boolean[] array = new boolean[n+1];
		// Initialisierung des Arrays
		for (int i = 0; i <=n; i++) {
			array[i] = true;
		}
		
		// Sieb-Algorithmus
		for (int i = 2; i <= Math.sqrt(obere); i++) {
			if ((i==2) || (i%2 !=0)) {
				for (int j = i * i; j <= obere; j += i) {
					if (j < untere) {
						continue;
					} else {
						array[j - untere] = false;
					}
				} 
			}
		}
		// Hinzufügen der gefundenen Primzahlen zur Ausgabe-Liste
		for (int i = 2; i < array.length; i++) {
			if (array[i]) {
				ausgabe.add((long)(i+untere));
			}
		}
		
		return ausgabe;
		
	}
}
