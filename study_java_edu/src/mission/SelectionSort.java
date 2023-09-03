package mission;

import java.util.Random;

public class SelectionSort {
	
	public int[] initializeArray() {
		Random rd = new Random();
		int[] arr = new int[10];
		int i, j;
		
		for (i = 0; i < arr.length; ) {
			int r = rd.nextInt(1, 101);
			for (j = 0; j < i; j++) {
				if (arr[j] == r) break;
			}
			if (j == i) arr[i++] = r;
		}
		
		return arr;
	}
	
	public void printArray(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println("\n" + "=".repeat(29));
	}
	
	public int[] sort(int[] arr) {
		int k = 0;
	for (int len = arr.length; 1 < len; len--) {	
		for (int i = 0; i < len; i++) {
			if (arr[k] < arr[i]) k = i;
			else { continue; }
		}
		
		int t = arr[len-1];
		arr[len -1] = arr[k];
		arr[k] = t;
		
	}
		return arr;
	}
		
	public static void main(String[] args) {
		SelectionSort ss = new SelectionSort();
		
		int[] arr = ss.initializeArray();
		ss.printArray(arr);
		arr = ss.sort(arr);
		ss.printArray(arr);
		
	}
}
