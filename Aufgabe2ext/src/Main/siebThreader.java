package Main;
import java.util.ArrayList;
import java.util.List;

//Parent Klasse fuer siebAtkin und siebEratosthenes
public abstract class siebThreader implements Runnable{
	int untere; //Untere grenze
	int obere; //Obere Grenze
	int thread_nummer; //Nummer des Threads
	List<Long> ergebnis;//Liste zur Speicherung der Ergebnisse
	
	public siebThreader(int untere,int obere, int nummer,List<Long> ergebnis) {
		this.untere = untere;
		this.obere = obere;
		this.thread_nummer = nummer;
		this.ergebnis=ergebnis;
	}
	// Abstrakte Methode zur Implementierung des Primzahl-Berechnungsalgorithmus
	abstract ArrayList<Long> primeChecker(int untere, int obere);
	
	@Override
	public void run() {// Führt den Primzahl-Berechnungsalgorithmus aus und fügt die Ergebnisse zur Ergebnisliste hinzu
		this.ergebnis.addAll(primeChecker(untere, obere));
	}
}
