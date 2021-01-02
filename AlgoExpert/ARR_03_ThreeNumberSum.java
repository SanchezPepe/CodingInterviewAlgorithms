import java.util.*;

class Program {
	public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
		Arrays.sort(array);
		List<Integer[]> ans = new ArrayList<Integer[]>();
		for(int i = 0; i < array.length - 2; i++){
			int left = i + 1;
			int right = array.length - 1;
			while(left < right){
				int currentSum = array[i] + array[left] + array[right];
				if(currentSum == targetSum){
					Integer newTriplet[] = {array[i], array[left], array[right]};
					ans.add(newTriplet);
					left++;
					right--;
				} else if(currentSum > targetSum) right--;
				else left++;
			}
		}
    return ans;
  }
}
