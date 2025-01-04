package EclipseProbe;



import org.junit.Test;

import junit.framework.Assert;

public class EclipseProbe {

	public static String ToRoman(int zahl) {
		int[] Zahlen = {1000, 900, 500, 400, 100, 90, 50, 40, 10 ,9 , 4, 1};
		
		String[] Roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X","IX","V","IV","I"};
		StringBuilder result = new StringBuilder();
		
		for(int i =0;i<Zahlen.length;i++) {
			while(zahl >= Zahlen[i]) {
				result = result.append(Roman[i]);
				}
			zahl -= Zahlen[i];
			}
		
		return result.toString();
		}
	
	
	public static void main(String[] args) {
	System.out.println(ToRoman(99));
	}
		
	
}

	