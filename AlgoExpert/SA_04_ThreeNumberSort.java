import java.util.*;

/**
	We declare 3 pointers first, second at 0 and third at the end of the array
	We move the second array and if we find the first or the last elem. in the order we make a swap
	If we swap with the first elem, we increment both of the pointers (1st and 2nd)
	If we swap with the last elem, we decrement only the last one (3rd one)

	We loop while the index of the second pointer is less than the index of the third pointer.

	TC - O(n) - We sort the array on the first pass as we move the indexes and make the swaps
	SC - O(1) - The sort is done in place, no aditional memory is needed
	**/

class Program {
    public int[] threeNumberSort(int[] array, int[] order) {
        int firstIdx = 0;
        int secondIdx = 0;
        int thirdIdx = array.length - 1;

        int firstItem = order[0];
        int secondItem = order[1];

        while (secondIdx<= thirdIdx) {
            int item = array[secondIdx];

            if (item == firstItem) {
                swap(array, firstIdx, secondIdx);
                firstIdx++;
                secondIdx++;
            } else if (item == secondItem) {
                secondIdx++;
            } else {
                // Match with the third element in order
                swap(array, secondIdx, thirdIdx);
                thirdIdx--;
            }
        }
        return array;
    }

    public void swap(int array[], int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
