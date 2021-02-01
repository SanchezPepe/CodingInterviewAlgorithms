import java.util.*;
/**
	Insetion sort:
	The first element is marked as sorted, so we start at array[1]
	For each of the remaining elements the compare it with the numbers on the left.
	If the actual number<left neighbour => we perform a left swap.
	Once the number reaches the start of the array or its left neighbour is greater that number we
	consider the element sorted

	TC O(n^2) - In the Worst case the array is reversed [4,3,2,1]. For each element O(n) we iterate 
		from right to left O(n), so it's O(n) * O(n) = O(n^2)
	SC O(1) - No aditional memory is required. Sorting it's done in place.
*/

class Program {
    public static int[] insertionSort(int[] array) {
        // First element is 'sorted'
        for (int i = 1; i<array.length; i++) {
            int temp = i;
            while (temp > 0 && array[temp - 1] > array[temp]) {
                leftSwap(array, temp);
                temp--;
            }
        }

        return array;
    }

    public static void leftSwap(int[] array, int index) {
        int temp = array[index - 1];
        array[index - 1] = array[index];
        array[index] = temp;
    }
}