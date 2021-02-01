import java.util.*;

class Program {
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        // Write your code here.
        int left = 0;
        int right = array.size() - 1;

        while (left<right) {
            while (right > 0 && array.get(right) == toMove) right--;
            while (left<array.size() && array.get(left) != toMove) left++;

            if (left<right) swap(array, left, right);
        }
        return array;
    }

    public static void swap(List<Integer> a, int i, int j) {
        int temp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, temp);
    }
}