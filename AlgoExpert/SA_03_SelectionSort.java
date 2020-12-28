import java.util.*;

/**
	Selection Sort
	For each element we need to find a smaller number in the array and swap
	If no number is found, the actual number is already sorted

	TC - O(n^2) - For each element we iterate all the array to find a smaller value
	SC - O(1) - No aditional memory is required

*/

class Program {
	public static int[] selectionSort(int[] array) {

		for (int i = 0; i<array.length; i++) {
			int min = array[i];
			int minIdx = -1;

			for (int j = i; j<array.length; j++) {
				if (array[j]<min) {
					min = array[j];
					minIdx = j;
				}
			}
			if (minIdx != -1)
				swap(array, i, minIdx);

		}
		return array;
	}

	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		return;
	}
}