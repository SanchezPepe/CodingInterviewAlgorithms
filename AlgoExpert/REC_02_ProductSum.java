import java.util.*;

/**
	We need to keep track of the depth of the current recursion.

	Start itterating the array
	Base case:
		We the array only contains numbers, no arrays or any other obj
		We sum all the numbers on it and return the sum multiplied by the depth of the array
	Recursive call:
		If we found an array inside we made the recursive call, increasing the depth.
		After the recursive call is done the value is added to the sum of that specific array and depth

	TC O(n) - Where n is the number of elems in the array incluing sub-elements
	SC O(d) - Greatest depth of the special arrays in the array
*/

class Program {
    // Tip: You can use `element instanceof ArrayList` to check whether an item
    // is an array or an integer.
    public static int productSum(List<Object> array) {
        return productSum(array, 1);
    }

    public static int productSum(List<Object> array, int depth) {
        int sum = 0;
        for (Object o: array) {
            if (o instanceof ArrayList) { // Found an special array, recursive call
                sum += productSum((List<Object> ) o, depth + 1);
            } else { //It's an integer
                sum += (Integer) o;
            }
        }
        return sum * depth;
    }
}