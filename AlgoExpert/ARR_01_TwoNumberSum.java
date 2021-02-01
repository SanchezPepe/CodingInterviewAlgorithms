import java.util.*;

class Program {
    public static int[] twoNumberSum(int[] array, int targetSum) {
        HashSet<Integer> seen = new HashSet<Integer> ();
        for (int actual: array) {
            if (seen.contains(targetSum - actual)) {
                return new int[] {
                    actual, (targetSum - actual)
                };
            } else {
                seen.add(actual);
            }
        }

        return new int[0];
    }
}