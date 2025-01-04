import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Test;

public class InsertionSort {
	
	public static int[] insertionSort(int[] elements) {
		for(int i =1; i< elements.length; i++) {
			int einzusortiender_wert = elements[i];
			int j = i;
			while(j > 0 && elements[j-1]> einzusortiender_wert) {
				elements[j] = elements[j-1];
				j -=1;
			}
			elements[j] = einzusortiender_wert;
		}
		return elements;
	}

	
	@Test
	public void test() {
		int[] elements = {5,33,12,14,7,2,52};
		int[] sorted_elements = insertionSort(elements);
		
		Assert.assertArrayEquals(elements, sorted_elements);
		
		
		for(int i =0; i< sorted_elements.length; i++) {
		System.out.println(sorted_elements[i]);
		}
	}

}
