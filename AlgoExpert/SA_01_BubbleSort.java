import java.util.*;

/**
	Consists in two for loops, on each iteration we compare two elements a = a[i] and b = a[i+1]
	If after one loop no swap occurs means the array is sorted bcs for all elements a is always<= than b
	If a<b we perform a swap, and turn on flag to track that swap at the end of the loop
	----------
	TC O(n^2)
	SP O(1) - Each swap is done in place, no extra memory is needed
*/

class Program {
    public static int[] bubbleSort(int[] array) {
        // Write your code here.
        for (int i = array.length - 1; i >= 0; i--) {
            boolean swap = false;
            for (int j = 0; j<i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(j, j + 1, array);
                    swap = true;
                }
            }
            if (!swap) return array;
        }
        return array;
    }

    public static void swap(int a, int b, int[] array) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}