import java.util.ArrayList;
import java.util.List;

public abstract class siebThreader implements Runnable{
	int untere;
	int obere;
	int thread_nummer;
	List<Long> ergebnis;
	
	public siebThreader(int untere,int obere, int nummer,List<Long> ergebnis) {
		this.untere = untere;
		this.obere = obere;
		this.thread_nummer = nummer;
		this.ergebnis=ergebnis;
	}
	
	abstract ArrayList<Long> primeChecker(int untere, int obere);
	
	@Override
	public void run() {
		this.ergebnis.addAll(primeChecker(untere, obere));
	}
}
