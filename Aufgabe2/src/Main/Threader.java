// Quelle : https://de.wikipedia.org/wiki/Sieb_des_Eratosthenes
package Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

//Klasse, die die Runnable-Schnittstelle implementiert, um in einem Thread ausgeführt zu werden
public class Threader implements Runnable{
	
	int untere;// Untere Grenze
	int obere;// Obere Grenze 
	int thread_nummer; // Nummer des Threads
	List<Long> ergebnis;// Liste zur Speicherung der Ergebnisse
	public Threader(int untere,int obere, int nummer,List<Long> ergebnis) {
		this.untere = untere;
		this.obere = obere;
		this.thread_nummer = nummer;
		this.ergebnis=ergebnis;
	}
	

	// Statische Methode zur Implementierung des Siebs des Eratosthenes
	// Berechnet Primzahlen im Bereich von `untere` bis `obere`
	public static ArrayList<Long> siebDesEratosthenes(int untere, int obere) {
		// Berechnung der Anzahl der Zahlen im Bereich
		int n = obere- untere;
		ArrayList<Long> ausgabe = new ArrayList<Long>();
		// Boolean-Array zur Markierung der Zahlen (true = potentiell prim)
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



	@Override
	public void run() {
		// Ergebnisse des Siebs des Eratosthenes zur gemeinsamen Ergebnisliste hinzufügen
		this.ergebnis.addAll(siebDesEratosthenes(untere, obere));
	}
	
	
}
