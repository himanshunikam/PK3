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
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Enumeration;


public class Main {
	// Methode zur Ausgabe eines Arrays. Falls das Array mehr als 200 Elemente hat,
	// werden nur die ersten und letzten 100 Elemente ausgegeben.
	private static void printArray(Object[] ausgabe) {
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
	private static void multiThreading(int obere, int thread_nummer, int threader_wahl) {
		// Thread-Pool wird mit der angegebenen Anzahl von Threads erstellt
		ExecutorService executorService = Executors.newFixedThreadPool(thread_nummer);
		// Synchronized-Liste für die Ergebnisse
		List<Long> ausgabe = Collections.synchronizedList(new ArrayList<>());
		long start = System.currentTimeMillis();
		// Aufteilung der Arbeit zwischen den Threads
		for (int i = 0, j=0; i < thread_nummer; i++, j++) {
			// Auswahl der Berechnungsmethode basierend auf der Eingabe "threader_wahl"
			switch(threader_wahl) {
			case 1:// Verwendung des Fermat-Algorithmus
				if (i==thread_nummer-1) {
//					System.out.println("Thread "+i+" Calculating between: "+j*(obere/thread_nummer)+" and "+obere);
					FermatThreader threader = new FermatThreader(j*(obere/thread_nummer), obere, i, ausgabe);
					executorService.submit(threader);
				}
				else {
//					System.out.println("Thread "+i+" Calculating between: "+j*(obere/thread_nummer)+" and "+(j+1)*(obere/thread_nummer));
					FermatThreader threader = new FermatThreader(j*(obere/thread_nummer), (j+1)*(obere/thread_nummer), i, ausgabe);
					executorService.submit(threader);
					}
				break;
			case 2:// Verwendung des Miller-Rabin-Algorithmus
				if (i==thread_nummer-1) {
//					System.out.println("Thread "+i+" Calculating between: "+j*(obere/thread_nummer)+" and "+obere);
					MillerRabinThreader threader = new MillerRabinThreader(j*(obere/thread_nummer), obere, i, ausgabe);
					executorService.submit(threader);
				}
				else {
//					System.out.println("Thread "+i+" Calculating between: "+j*(obere/thread_nummer)+" and "+(j+1)*(obere/thread_nummer));
					MillerRabinThreader threader = new MillerRabinThreader(j*(obere/thread_nummer), (j+1)*(obere/thread_nummer), i, ausgabe);
					executorService.submit(threader);
					}
				break;
			case 3:// Verwendung des Solovay-Strassen-Algorithmus
				if (i==thread_nummer-1) {
//					System.out.println("Thread "+i+" Calculating between: "+j*(obere/thread_nummer)+" and "+obere);
					SolovayStrassenThreader threader = new SolovayStrassenThreader(j*(obere/thread_nummer), obere, i, ausgabe);
					executorService.submit(threader);
				}
				else {
//					System.out.println("Thread "+i+" Calculating between: "+j*(obere/thread_nummer)+" and "+(j+1)*(obere/thread_nummer));
					SolovayStrassenThreader threader = new SolovayStrassenThreader(j*(obere/thread_nummer), (j+1)*(obere/thread_nummer), i, ausgabe);
					executorService.submit(threader);
					}
				break;
			
			case 4: // Verwendung des Siebs von Atkin
				if (i==thread_nummer-1) {
//					System.out.println("siebAtkin Thread "+i+" Calculating between: "+j*(obere/thread_nummer)+" and "+obere);
					siebAtkin threader = new siebAtkin(j*(obere/thread_nummer), obere, i, ausgabe);
					executorService.submit(threader);
				}
				else {
//					System.out.println("Thread "+i+" Calculating between: "+j*(obere/thread_nummer)+" and "+(j+1)*(obere/thread_nummer));
					siebAtkin threader = new siebAtkin(j*(obere/thread_nummer), (j+1)*(obere/thread_nummer), i, ausgabe);
					executorService.submit(threader);
					}
				break;
			case 5:// Verwendung des Siebs des Eratosthenes
				if (i==thread_nummer-1) {
//					System.out.println("siebEratosthenes Thread "+i+" Calculating between: "+j*(obere/thread_nummer)+" and "+obere);
					siebEratosthenes threader = new siebEratosthenes(j*(obere/thread_nummer), obere, i, ausgabe);
					executorService.submit(threader);
				}
				else {
//					System.out.println("Thread "+i+" Calculating between: "+j*(obere/thread_nummer)+" and "+(j+1)*(obere/thread_nummer));
					siebEratosthenes threader = new siebEratosthenes(j*(obere/thread_nummer), (j+1)*(obere/thread_nummer), i, ausgabe);
					executorService.submit(threader);
					}
				break;
				}
			}
		executorService.shutdown();
		try {// Warten auf die Beendigung aller Threads mit einem Timeout von 5 Minuten
			if(executorService.awaitTermination(15, TimeUnit.MINUTES)) {
				// Berechnung der Dauer und Ausgabe der Ergebnisse
				long end = System.currentTimeMillis();
				System.out.println("Dauer: "+ (end - start));
//				System.out.println("Ausgabe:");
				System.out.println("ausgabe size: "+ausgabe.size());
				// Ergebnisse sortiert ausgeben
				printArray(ausgabe.toArray());
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
			if (obere > 1000000000||obere<1) {// Überprüfung, ob die Eingabe gültig ist
				throw new IllegalArgumentException("Falsche Eingabe");
			}
			return obere;
		} catch (Exception e) {
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
			if (thread_nummer> 12 || thread_nummer>obere ||thread_nummer<1) {// Überprüfung, ob die Eingabe gültig ist
				throw new IllegalArgumentException("Falsche Eingabe");
			}
			return thread_nummer;
		} catch (Exception e) {
			System.out.println("Falsche Eingabe, wider versuchen: ");
			return takeThreadNummerInput(obere);
		}
	}
	// Methode zur Eingabe der Threader wahl
	public static int takeThreaderWahlInput() {
		int threader_wahl=1;
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.print("Threader waehlen: " + '\n' + "1-> Fermat"+ '\n' +"2-> Miller Rabin"+ '\n' +"3-> Solovay Strassen"+ '\n' +"4-> Sieb von Atkin"+ '\n' +"5-> Sieb von Eratosthenes" + '\n' +"Ihre Wahl: ");
			threader_wahl = scanner.nextInt();
			if (threader_wahl > 5 || threader_wahl<1) {//Überprüfung, ob die Eingabe gültig ist
				throw new IllegalArgumentException("Falsche Eingabe");
			}
			return threader_wahl;
		} catch (Exception e) {
			System.out.println("Falsche Eingabe, wider versuchen: ");
			return takeThreaderWahlInput();
		}
	}
	// Hauptmethode
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		int thread_nummer;
		int obere;
		int threader_wahl;
		
		obere = takeObereInput();
		thread_nummer = takeThreadNummerInput(obere);
		threader_wahl=takeThreaderWahlInput();	
		// Start der Multithreading-Operation
		multiThreading(obere, thread_nummer, threader_wahl);
		// 1000000
		//100000000
		//300000000
		//1000000000
		
	
	}

}
