// Notes: https://snchzpepe.notion.site/Two-Number-Sum-05a5eca18977445e86d597971a2766ed

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
