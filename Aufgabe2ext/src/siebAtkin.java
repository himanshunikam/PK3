// Algorithmus Quelle : https://www.geeksforgeeks.org/sieve-of-atkin/?ref=header_outind

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//Klasse siebAtkin, die von der Klasse siebThreader erbt
//Implementiert das Sieb von Atkin zur effizienten Berechnung von Primzahlen
public class siebAtkin extends siebThreader{
	int untere; //Untere Grenze
	int obere;  //Obere Grenze
	int thread_nummer; // Nummer des Threads
	List<Long> ergebnis;//Liste zur speicherung von ergebnisse
	public siebAtkin(int untere, int obere, int nummer, List<Long> ergebnis) {
		super(untere, obere, nummer, ergebnis);
		// TODO Auto-generated constructor stub
	}

	// Methode zur Berechnung der Primzahlen im angegebenen Bereich mithilfe des Siebs von Atkin
	public ArrayList<Long> primeChecker(int untere, int obere) {
		int m = obere- untere;
		ArrayList<Long> ausgabe = new ArrayList<Long>();
		boolean[] sieve = new boolean[m+1];
		
		if (untere<5) {
			ausgabe.add(2L);
			ausgabe.add(3L);
		}
		
		for (int i = 0; i < obere-untere; i++) {
			sieve[i] = false;
		}
		// Anwendung der mathematischen Bedingungen des Siebs von Atkin
		for (int x = 1; x*x < obere; x++) {
			for (int y = 0; y*y < obere; y++) {
				int n = (4*x*x)+(y*y);
				if(n<=obere && (n%12==1 || n%12==5) && n>=untere) {
					sieve[n-untere] = sieve[n-untere]^true;
				}
				n = (3*x*x)+(y*y);
				if (n<=obere && n%12==7 && n>=untere) {
					sieve[n-untere] =sieve[n-untere]^true;
				}
				
				n= (3*x*x)-(y*y);
				if (x>y && n<=obere && n%12==11 && n>=untere) {
					sieve[n-untere] =sieve[n-untere]^true;
				}
			}
		}
		// Eliminierung von Zahlen, die Vielfache von Quadraten sind
		for (int i = 5; i*i < obere; i++) {
			if ((i-untere)>=0) {
				if (sieve[i - untere]) {
					for (int j = i * i; j < obere; j += i * i) {
						sieve[j - untere] = false;
					}
				} 
			}
		}
		// Hinzufügen aller als "prim" markierten Zahlen zur Ausgabeliste
		for (int i = 0; i < sieve.length; i++) {
			if (sieve[i]) {
				ausgabe.add((long) i+untere);
			}
		}
		
		return ausgabe;
	}
}
