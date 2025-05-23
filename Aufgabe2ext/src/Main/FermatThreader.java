// Quelle : https://www.geeksforgeeks.org/fermat-method-of-primality-test/?ref=header_outind
package Main;

import java.util.List;
//Klasse FermatThreader, die von der Klasse Threader erbt
//Implementiert den Fermat-Test zur Überprüfung von Primzahlen
public class FermatThreader extends Threader{
	public FermatThreader(int untere, int obere, int nummer, List<Long> ergebnis) {
		super(untere, obere, nummer, ergebnis);
		// TODO Auto-generated constructor stub
	}
	// Methode zur Überprüfung, ob eine Zahl n eine Primzahl ist, basierend auf dem Fermat-Test
	// k gibt die Anzahl der Iterationen des Tests an
	boolean isPrime(long n, long k) {
		if((n%2==0 && n!=2)||n==1) {
			return false;
		}
		if(n<=3) {
			return true;
		}
		// Durchführung des Fermat-Tests k-mal
		while(k>0) {
			int a = 2+ (int)(Math.random()%(n));
			
			if(power(a,n-1,n)!=1) {
				return false;
			} 
			k--;
		}
		return true;
	}
//	@Override
//	public void run() {
//		primeChecker(this.untere, this.obere, this.ergebnis);
//	}
}
