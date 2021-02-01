import java.util.*;

class Program {
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int p1 = 0, p2 = 0;
        for (p2 = 0; p2<array.size(); p2++) {
            if (array.get(p2).equals(sequence.get(p1))) {
                p1++;
            }
            if (p1 == sequence.size()) {
                return true;
            }
        }
        return false;
    }
}