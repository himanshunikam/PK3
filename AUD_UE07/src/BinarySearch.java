
public class BinarySearch {
	public static int binary_search(int start_idx, int end_idx, int[] array, int zahl) {
		int i = start_idx+ (end_idx-start_idx)/2;
		if(array[i]==zahl) {
			return i;
		}
		else if(array[i]>zahl) {
			return binary_search(start_idx, i, array, zahl);
		}
		else {
			return binary_search(i+1, end_idx, array, zahl);
		}
		
	}
	public static void main(String[] args) {
		int [] array = {0,1,2,3,4,5,6,7,8,9};
		System.out.println(binary_search(0,10,array,9));
	}
}
