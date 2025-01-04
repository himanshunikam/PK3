import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MillerRabinThreader extends Threader{
	
	public MillerRabinThreader(int untere, int obere, int nummer, List<Long> ergebnis) {
		super(untere, obere, nummer, ergebnis);
		// TODO Auto-generated constructor stub
	}
	static boolean isStrongPseudoPrime(long d, long n) {
		long a = 2+(int)(Math.random()%(n-4));
		long x = power(a,d,n);
		if (x==1| x==n-1) {
			return true;
		}
		while (d!=n-1) {
			x=(x*x)%n;
			d=d*2;
			
			if (x==1) {
				return false;
			}
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
		long d= n-1;
		while (d%2==0) {
			d = d/2;
		}
		for (int i = 0; i < 3; i++) {
			if(!isStrongPseudoPrime(d,n)) return false;
		}
		return true;
	}
	
}
