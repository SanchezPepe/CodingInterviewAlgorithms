import java.util.*;

/**
	Divide and conquer technique
	We start at the middle of the array m = a[a.length/2];
	We need to create two pointers to handle the bounds of the search

	First we check if m == targe. If it's different:
		If m<target -> We search in the upper half of the array
		If m > target -> We search in the lower half of the array

	This can be solved by using recursion:
	Base case:
		Found the element or,
		LeftBound == RightBound -> The element doesn't exists in the array

	Recursive call:
		When m != target, updating the bounds of the search

	TC O(log(n)) - geeksforgeeks.org/complexity-analysis-of-binary-search/
	SC O(1) - The size of the input doesn't matter
*/

class Program {
    public static int binarySearch(int[] array, int target) {

        return binarySearch(array, target, 0, array.length - 1);
    }

    public static int binarySearch(int[] array, int target, int left, int right) {

        if (left > right) return -1;

        int middle = (right + left) / 2;
        int half = array[middle];

        if (half == target) return middle;
        else if (half > target) return binarySearch(array, target, left, middle - 1);
        else return binarySearch(array, target, middle + 1, right);
    }
}