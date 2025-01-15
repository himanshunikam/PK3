package Main;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;



public class Main {
	
	// Methode zur Ausgabe eines Arrays. Falls das Array mehr als 200 Elemente hat,
	// werden nur die ersten und letzten 100 Elemente ausgegeben
	public static void printArray(Object[] ausgabe) {
		// Array wird sortiert
		Arrays.sort(ausgabe);
		if (ausgabe.length> 200) {
			System.out.println("Erste 100 Zahlen : ");
			for (int i = 0; i < 100; i++) {
				System.out.println(ausgabe[i]);
			}
			System.out.println("Letzte 100 Zahlen : ");
			for (int i = ausgabe.length-100; i < ausgabe.length; i++) {
				System.out.println(ausgabe[i]);
			}
		}else {
			for (Object object : ausgabe) {
				System.out.println(object);
			}
		}
	}
	// Methode zur Ausführung einer Multithreading-Operation mit einer definierten Anzahl von Threads
	private static void multiThreading(int obere, int thread_nummer) {
		// Thread-Pool wird mit der angegebenen Anzahl von Threads erstellt
		ExecutorService executorService = Executors.newFixedThreadPool(thread_nummer);
		// Synchronized-Liste für die Ergebnisse
		List<Long> ausgabe = Collections.synchronizedList(new ArrayList<>());
		long start = System.currentTimeMillis();
		// Aufteilung der Arbeit zwischen den Threads
		for (int i = 0, j=0; i < thread_nummer; i++, j++) {
			if (i==thread_nummer-1) {
				// Letzter Thread übernimmt den Restbereich
//				System.out.println("Thread "+i+" Calculating between: "+j*(obere/thread_nummer)+" and "+obere);
				Threader threader = new Threader(j*(obere/thread_nummer), obere, i, ausgabe);
				executorService.submit(threader);
			}
			else {
				// Bereichszuweisung für die anderen Threads
//				System.out.println("Thread "+i+" Calculating between: "+j*(obere/thread_nummer)+" and "+(j+1)*(obere/thread_nummer));
				Threader threader = new Threader(j*(obere/thread_nummer), (j+1)*(obere/thread_nummer), i, ausgabe);
				executorService.submit(threader);
				}	
			
			}
		executorService.shutdown();
		try {// Warten auf die Beendigung aller Threads
			if(executorService.awaitTermination(15, TimeUnit.MINUTES)) {
				long end = System.currentTimeMillis();
				System.out.println("Dauer: "+ (end - start));
				System.out.println("Ausgabe:");
				System.out.println("ausgabe size: "+ausgabe.size());
				printArray(ausgabe.toArray()); // Ausgabe der Ergebnisse
			}else {
				System.out.println("error");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	// Methode zur Eingabe der oberen Grenze
	public static int takeObereInput() {
		int obere=1;
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.print("Obere grenze eingeben: ");
			obere = scanner.nextInt();
			if (obere > 1000000000 || obere<1) {// Überprüfung, ob die Eingabe gültig ist
				throw new IllegalArgumentException("Falsche Eingabe");
			}
			return obere;
		} catch (Exception e) {
			// Fehlerhafte Eingabe, erneuter Versuch
			System.out.println("Falsche Eingabe, wider versuchen: ");
			return takeObereInput();
		}
	}
	// Methode zur Eingabe der Anzahl der Threads
	public static int takeThreadNummerInput(int obere) {
		int thread_nummer=1;
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.print("Anzahl der Threads eingeben: ");
			thread_nummer = scanner.nextInt();
			if (thread_nummer> 12 || thread_nummer>obere||thread_nummer<0) {// Überprüfung, ob die Eingabe gültig ist
				throw new IllegalArgumentException("Falsche Eingabe");
			} else {
				return thread_nummer;
			}
			
			
		} catch (Exception e) {
			// Fehlerhafte Eingabe, erneuter Versuch
			System.out.println("Falsche Eingabe, wider versuchen: ");
			return takeThreadNummerInput(obere);
		}
	}
	// Hauptmethode
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		int thread_nummer;
		int obere;
		// Eingabe der oberen Grenze und Anzahl der Threads
		obere = takeObereInput();
		thread_nummer=takeThreadNummerInput(obere);
		// Start der Multithreading-Operation
		multiThreading(obere, thread_nummer);
		
		
	
	}

}
