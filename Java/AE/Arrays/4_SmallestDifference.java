import java.util.*;

class Program {
  public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
		Arrays.sort(arrayOne);
		Arrays.sort(arrayTwo);
		
		int x = 0, y = 0;
		int min = Integer.MAX_VALUE;
		int p1 = 0, p2 = 0;
		
		while(p1 < arrayOne.length && p2 < arrayTwo.length){
			int a = arrayOne[p1];
			int b = arrayTwo[p2];
			if(Math.abs(a - b) < min){
				min = Math.abs(a - b);
				x = a;
				y = b;
			}
			if(a < b) p1++;
			else p2++;
		}
    return new int[] {x,y};
  }
}
