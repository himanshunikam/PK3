package Main;
import java.util.List;

public abstract class Threader implements Runnable{
	int untere; // Untere Grenze
	int obere; //Obere grenze
	int thread_nummer; //Nummer des Threads
	List<Long> ergebnis; //Liste zur Speicherung der Ergebnisse
	
	public Threader(int untere,int obere, int nummer,List<Long> ergebnis) {
		this.untere = untere;
		this.obere = obere;
		this.thread_nummer = nummer;
		this.ergebnis=ergebnis;
	}
	// Methode zur Überprüfung aller Zahlen im Bereich auf Primzahleigenschaften
	public void primeChecker(int untere, int obere, List<Long> ergebnis) {
		for (int i = untere; i < obere; i++) {
			if (isPrime(i, 20)) {
				ergebnis.add((long) i);
			}
		}
	}
	// Berechnet (a^n) % p 
	static long power(long a, long n, long p) {
		long res=1;
		
		while (n>0) {
			if ((n%2)==1) {
				res = (res*a)%p;
				n--;
			}else {
				a = (a*a)%p;
				n= n/2;
			}
		}
		return res;
	}
	// Abstrakte Methode zur Primzahlprüfung
	abstract boolean isPrime(long n, long k) ;
	// Führt die Primzahlprüfung im Bereich [untere, obere) aus
	@Override
	public void run() {
		primeChecker(this.untere, this.obere, this.ergebnis);
	}
}
