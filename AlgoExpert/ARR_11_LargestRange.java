import java.util.*;

class Program {
    public static int[] largestRange(int[] array) {
        // Write your code here.
        HashMap<Integer, Boolean> nums = new HashMap<>();

        for (int num: array) nums.put(num, false);

        int maxLenght = -1;
        int start = 0, end = 0;

        for (int num: array) {
            if (!nums.get(num)) {
                int size = 0;
                int left = num;
                while (nums.containsKey(left) && !nums.get(left)) {
                    nums.put(left, true);
                    left--;
                    size++;
                }
                int right = num + 1;
                while (nums.containsKey(right) && !nums.get(right)) {
                    nums.put(right, true);
                    right++;
                    size++;
                }
                if (size > maxLenght) {
                    maxLenght = size;
                    start = left + 1;
                    end = right - 1;
                }
            }
        }
        return new int[] {
            start, end
        };
    }
}