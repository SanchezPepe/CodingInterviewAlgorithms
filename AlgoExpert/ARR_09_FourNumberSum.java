import java.util.*;

class Program {
    public static List<Integer[] > fourNumberSum(int[] array, int targetSum) {
        // Write your code here.
        HashMap<Integer, List<Integer[] >> map = new HashMap<>();
        List<Integer[] > quadruplets = new ArrayList<Integer[] > ();

        //Calculate the sum of all the pairs
        for (int i = 1; i<array.length; i++) {
            // From left to right
            for (int j = i + 1; j<array.length; j++) {
                int sum = array[i] + array[j];
                int comp = targetSum - sum;
                if (map.containsKey(comp)) { //Found quadruplet
                    for (Integer[] p: map.get(comp)) {
                        Integer[] newQuad = {
                            p[0], p[1], array[i], array[j]
                        };
                        quadruplets.add(newQuad);
                    }
                }
            }
            // From right to left
            for (int k = 0; k<i; k++) {
                int sum = array[i] + array[k];
                Integer[] newPair = {
                    array[k], array[i]
                };
                if (map.get(sum) == null) {
                    List<Integer[] > pair = new ArrayList<Integer[] > ();
                    pair.add(newPair);
                    map.put(sum, pair);
                } else {
                    map.get(sum).add(newPair);
                }
            }
        }

        return quadruplets;
    }
}