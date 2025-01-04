import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Test;

public class BubbleSort {
	
	public static int[] bubbleSort(int[] elements) {
		int l = elements.length;
		boolean swapped;
		do{
			swapped = false;
			for(int i =0; i<l-1; i++) {
				if(elements[i] > elements[i+1]) {
					int temp = elements[i+1];
					elements[i+1] = elements[i];
					elements[i] = temp;
					swapped = true;
				}
			}
			l -= 1;
		}while(swapped);
		return elements;
	}
	
	/*
	public static int[] bubbleSort2(int[] elements) {
		for(int l = elements.length; l>1; l--) {
			for(int i =0; i < l-1; i++) {
				if(elements[i]> elements[i+1]) {
					int temp = elements[i+1];
					elements[i+1] = elements[i];
					elements[i] = temp;
				}
			}
		}
		return elements;
	}*/
	
	@Test
	public void test() {
		int[] elements = {5,33,12,14,7,2,52};
		int[] sorted_elements = bubbleSort(elements);
		
		Assert.assertArrayEquals(elements, sorted_elements);
		
		for(int i =0; i< sorted_elements.length; i++) {
				System.out.println(sorted_elements[i]);
			}
	}
}
