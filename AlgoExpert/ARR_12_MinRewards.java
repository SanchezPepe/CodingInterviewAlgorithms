import java.util.*;

class Program {
  public static int minRewards(int[] scores) {
    // Write your code here.
		int rewards[] = new int[scores.length];
		Arrays.fill(rewards, 1);
		
		//Left to right
		for(int i = 0; i < scores.length-1; i++){
			if(scores[i] < scores[i+1])	
				rewards[i+1] = rewards[i]+1;
		}
		// Right to left
		for(int i = scores.length - 2; i >= 0; i--){
			if(scores[i] > scores[i+1])
				rewards[i] = Math.max(rewards[i], rewards[i+1] + 1);
		}

		int sum = 0;
		for(int num : rewards) sum += num;
		return sum;
	}
}
