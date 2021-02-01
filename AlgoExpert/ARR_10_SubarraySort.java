import java.util.*;

class Program {
    public static int[] subarraySort(int[] array) {
        // Write your code here.
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int start = 0, end = 0;

        for (int i = 0; i<array.length; i++) {
            int num = array[i];
            if (num >= max) {
                max = num;
            } else {
                if (num<min) min = num;
                end = i;
            }
        }

        if (min == Integer.MAX_VALUE)
            return new int[] {
                -1, -1
            };

        while (start<array.length) {
            if (array[start] > min) break;
            start++;
        }

        return new int[] {
            start, end
        };
    }
}