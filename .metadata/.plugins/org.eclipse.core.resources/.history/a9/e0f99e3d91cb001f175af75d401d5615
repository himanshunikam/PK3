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
	
	public static void printArray(Object[] ausgabe) {
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
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		int thread_nummer;
		int obere;
		int threader_wahl;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Obere grenze Eingeben: ");
		obere= scanner.nextInt();
		System.out.println("Anzahl der Threads Eingeben: ");
		thread_nummer = scanner.nextInt();
		System.out.println("Threader waehlen: ");
		threader_wahl = scanner.nextInt();
		scanner.close();
//		System.out.println("started...");
		if ((thread_nummer>obere)|| (thread_nummer>12)) {
			throw new IllegalArgumentException("Falsche Eingabe");
		}
		ExecutorService executorService = Executors.newFixedThreadPool(thread_nummer);

		List<Long> ausgabe = Collections.synchronizedList(new ArrayList<>());
		long start = System.currentTimeMillis();
		for (int i = 0, j=0; i < thread_nummer; i++, j++) {
			switch(threader_wahl) {
			case 1:
				if (i==thread_nummer-1) {
					System.out.println("Thread "+i+" Calculating between: "+j*(obere/thread_nummer)+" and "+obere);
					FermatThreader threader = new FermatThreader(j*(obere/thread_nummer), obere, i, ausgabe);
					executorService.submit(threader);
				}
				else {
					System.out.println("Thread "+i+" Calculating between: "+j*(obere/thread_nummer)+" and "+(j+1)*(obere/thread_nummer));
					FermatThreader threader = new FermatThreader(j*(obere/thread_nummer), (j+1)*(obere/thread_nummer), i, ausgabe);
					executorService.submit(threader);
					}
				break;
			case 2:
				if (i==thread_nummer-1) {
					System.out.println("Thread "+i+" Calculating between: "+j*(obere/thread_nummer)+" and "+obere);
					MillerRabinThreader threader = new MillerRabinThreader(j*(obere/thread_nummer), obere, i, ausgabe);
					executorService.submit(threader);
				}
				else {
					System.out.println("Thread "+i+" Calculating between: "+j*(obere/thread_nummer)+" and "+(j+1)*(obere/thread_nummer));
					MillerRabinThreader threader = new MillerRabinThreader(j*(obere/thread_nummer), (j+1)*(obere/thread_nummer), i, ausgabe);
					executorService.submit(threader);
					}
				break;
			case 3:
				if (i==thread_nummer-1) {
					System.out.println("Thread "+i+" Calculating between: "+j*(obere/thread_nummer)+" and "+obere);
					SolovayStrassenThreader threader = new SolovayStrassenThreader(j*(obere/thread_nummer), obere, i, ausgabe);
					executorService.submit(threader);
				}
				else {
					System.out.println("Thread "+i+" Calculating between: "+j*(obere/thread_nummer)+" and "+(j+1)*(obere/thread_nummer));
					SolovayStrassenThreader threader = new SolovayStrassenThreader(j*(obere/thread_nummer), (j+1)*(obere/thread_nummer), i, ausgabe);
					executorService.submit(threader);
					}
				break;
			
			case 4:
				if (i==thread_nummer-1) {
					System.out.println("siebAtkin Thread "+i+" Calculating between: "+j*(obere/thread_nummer)+" and "+obere);
					siebAtkin threader = new siebAtkin(j*(obere/thread_nummer), obere, i, ausgabe);
					executorService.submit(threader);
				}
				else {
					System.out.println("Thread "+i+" Calculating between: "+j*(obere/thread_nummer)+" and "+(j+1)*(obere/thread_nummer));
					siebAtkin threader = new siebAtkin(j*(obere/thread_nummer), (j+1)*(obere/thread_nummer), i, ausgabe);
					executorService.submit(threader);
					}
				break;
			case 5:
				if (i==thread_nummer-1) {
					System.out.println("siebAtkin Thread "+i+" Calculating between: "+j*(obere/thread_nummer)+" and "+obere);
					siebEratosthenes threader = new siebEratosthenes(j*(obere/thread_nummer), obere, i, ausgabe);
					executorService.submit(threader);
				}
				else {
					System.out.println("Thread "+i+" Calculating between: "+j*(obere/thread_nummer)+" and "+(j+1)*(obere/thread_nummer));
					siebEratosthenes threader = new siebEratosthenes(j*(obere/thread_nummer), (j+1)*(obere/thread_nummer), i, ausgabe);
					executorService.submit(threader);
					}
				break;
				}
			}
		executorService.shutdown();
		try {
			if(executorService.awaitTermination(5, TimeUnit.MINUTES)) {
				long end = System.currentTimeMillis();
				System.out.println("Dauer: "+ (end - start));
				System.out.println("Ausgabe:");
				System.out.println("ausgabe size: "+ausgabe.size());
				printArray(ausgabe.toArray());
			}else {
				System.out.println("error");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
	}

}
