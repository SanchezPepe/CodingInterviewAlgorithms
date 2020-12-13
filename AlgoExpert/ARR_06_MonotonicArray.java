import java.util.*;

class Program {
  public static boolean isMonotonic(int[] array) {
		if(array.length < 2) return true;
		
		boolean isDesc = (array[0] > array[array.length-1]) ? true : false;
		
		for(int i = 1; i < array.length; i++){
			if(array[i] > array[i-1] && isDesc) return false;
			if(array[i] < array[i-1] && !isDesc) return false;
		}
		
    return true;
  }
}
