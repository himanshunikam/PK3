// Algorithmus Quelle : https://www.geeksforgeeks.org/primality-test-set-3-miller-rabin/ 
package Main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
// Klasse MillerRabinThreader, die von der Klasse Threader erbt
//Implementiert den Miller-Rabin-Algorithmus zur Primzahlprüfung
public class MillerRabinThreader extends Threader{
	
	public MillerRabinThreader(int untere, int obere, int nummer, List<Long> ergebnis) {
		super(untere, obere, nummer, ergebnis);
		// TODO Auto-generated constructor stub
	}
	// Statische Methode zur Überprüfung, ob eine Zahl eine starke Pseudoprimzahl ist
	static boolean isStrongPseudoPrime(long d, long n) {
		// Zufällige Basis `a` zwischen 2 und (n-4)
		long a = 2+(int)(Math.random()%(n-4));
		// Berechnung von a^d % n
		long x = power(a,d,n);
		// Überprüfung der Bedingung x == 1 (mod n) oder x == -1 (mod n)
		if (x==1| x==n-1) {
			return true;
		}
		// Iterative Überprüfung der weiteren Bedingungen
		while (d!=n-1) {
			// Quadratisches Potenzieren
			x=(x*x)%n;
			d=d*2;
			// Wenn x == 1 (mod n), ist die Zahl keine starke Pseudoprimzahl
			if (x==1) {
				return false;
			}
			// Wenn x == -1 (mod n), ist die Zahl eine starke Pseudoprimzahl
			if(x==n-1) {
				return true;
			}
		}
		return false;
	}
	@Override
	boolean isPrime(long n, long k) {
		if (n<=1 || n==4) {
			return false;
		}
		if (n<=3) {
			return true;
		}
		// Berechnung von d, sodass n-1 = d * 2^r, wobei d ungerade ist
		long d= n-1;
		while (d%2==0) {
			d = d/2;
		}
		// Wiederholte Anwendung des Miller-Rabin-Tests
		for (int i = 0; i < 3; i++) {
			if(!isStrongPseudoPrime(d,n)) return false;
		}
		return true;
	}
	
}
