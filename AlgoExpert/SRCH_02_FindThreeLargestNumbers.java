import java.util.*;

/*
	Set three pointers at the first 3 elements, add them in an array and sort it
	The smallest number is at array[0]
	Traverse the array and look for a number greater than array[0]
	When we find a greater number, we swap the numbers and sort again to have the smallest 
	number at array[0]

	TC O(n) - We only traverse once the input array
	SC O(1) - We only need space for tracking the three largest numbers
*/

class Program {
    public static int[] findThreeLargestNumbers(int[] array) {
        int ans[] = {
            array[0], array[1], array[2]
        };
        Arrays.sort(ans);

        for (int i = 3; i<array.length; i++) {
            if (array[i] > ans[0]) {
                ans[0] = array[i];
                Arrays.sort(ans);
            }
        }
        return ans;
    }
}