import java.util.*;

class Program {
  public static int longestPeak(int[] a) {
    
		int maxPeak = 0;
		int i = 1;
		while(i < a.length - 1){
			boolean peak = (a[i-1] < a[i] && a[i+1] < a[i]);
			if(!peak){
				i++;
				continue;
			}
			
			int left = i - 2;
			while(left >= 0 && a[left] < a[left + 1]) left--;
			
			int right = i + 2;
			while(right < a.length && a[right] < a[right - 1]) right++;
				
			int size = right - left - 1;
			if(size > maxPeak) maxPeak = size;
				
			i = right;
		}
		
    return maxPeak;
  }
}
