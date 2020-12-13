import java.util.*;

class Program {
  public static List<Integer> spiralTraverse(int[][] array) {
    // Write your code here.
		List<Integer> ans = new ArrayList<Integer>();
		int xStart = 0, xEnd = array[0].length;
		int yStart = 0, yEnd = array.length;
		
		while(xStart < xEnd && yStart < yEnd){
			int control = xStart;
			
			while(control < xEnd) {
				ans.add(array[yStart][control]);
				control++;
			}		
			yStart++;
			control = yStart;
			
			while(control < yEnd){
				ans.add(array[control][xEnd-1]);
				control++;
			}
			
			xEnd--;
			control = xEnd-1;
			
			while(control >= xStart){
				if(yStart == yEnd) break;
				ans.add(array[yEnd-1][control]);
				control--;
			}
			
			yEnd--;
			control = yEnd-1;
			
			while(control >= yStart){
				if(xStart == xEnd) break;
				ans.add(array[control][xStart]);
				control--;
			}
			
			xStart++;
		}
    return ans;
  }
}
