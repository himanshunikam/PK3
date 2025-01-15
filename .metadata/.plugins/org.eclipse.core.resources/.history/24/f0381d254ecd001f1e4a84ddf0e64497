// Quelle : https://www.geeksforgeeks.org/solovay-strassen-method-of-primality-test/?ref=header_outind

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class SolovayStrassenThreader extends Threader{
	
	public SolovayStrassenThreader(int untere, int obere, int nummer, List<Long> ergebnis) {
		super(untere, obere, nummer, ergebnis);
		// TODO Auto-generated constructor stub
	}
	// Berechnet (base^exponent) % mod effizient
	static long modulo(long base, long exponent, long mod) {
		long x=1;
		long y= base;
		while (exponent>0) {
			if(exponent%2==1) {
				x=(x*y)%mod;// Wenn das aktuelle Bit von exponent 1 ist
			}
			y= (y*y)%mod; // Basis quadrieren
			exponent= exponent/2;// Exponent halbieren
		}
		return x%mod; // Rückgabe des modularen Ergebnisses
	}
	// Methode zur Berechnung des Jacobi-Symbols
	// Berechnet das Jacobi-Symbol (a/n)
	static long jacobian(long a, long n) {
		if(n<=0||(n%2==0&&n!=2)) {
			return 0;
		}
		long ans=1L;
		if(a<0) {
			a=-a;
			if (n%4==3) {
				ans=-ans;
			}
		}
		if (a==1) {
			return ans;
		}
		// Iterative Berechnung des Jacobi-Symbols
		while (a!=0) {
			if (a<0) {
				a=-a;
				if(n%4==3) {
					ans=-ans;
				}
			}
			while(a%2==0) {
				a=a/2;
				if (n%8==3||n%8==5) {
					ans=-ans;
				}
			}
			// Anwendung der wechselseitigen Regel
			long temp=a;
			a=n;
			n=temp;
			if (a%4==3&&n%4==3) {
				ans=-ans;
			}
			a=a%n;
			if (a>n/2) {
				a=a-n;
			}
		}
		// Wenn n = 1, ist das Ergebnis das Jacobi-Symbol
		if(n==1) {
			return ans;
		}
		return 0;// Andernfalls ist das Jacobi-Symbol undefiniert
	}
	@Override
	boolean isPrime(long n, long k) {
		if (n<2) {
			return false;
		}
		if ((n!=2&&n%2==0)) {
			return false;
		}
		Random random = new Random();
		// Durchführung des Solovay-Strassen-Tests k-mal
		for (int i = 0; i < k; i++) {
			// Zufällige Wahl von a im Bereich [1, n-1]
			long r= Math.abs(random.nextLong());
			long a= r%(n-1)+1;
			// Berechnung des Jacobi-Symbols und des modularen Exponentiationswerts
			long jacobian = (n+jacobian(a,n))%n;
			long mod=modulo(a,(n-1)/2,n);
			// Überprüfung der Bedingung: mod = Jacobi (mod n)
			if (jacobian==0||mod!=jacobian) {
				return false;
			}
		}
		return true;
	}
}
