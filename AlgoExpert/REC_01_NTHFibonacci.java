import java.util.*;

class Program {
	
	public static HashMap<Integer, Integer> calculated = new HashMap<Integer, Integer>();
	
  public static int getNthFib(int n) {
    
		if(n == 1) return 0;
		if(n == 2) return 1;
		
		int a;
		if(calculated.containsKey(n - 1)){
			a = calculated.get(n - 1);
		} else {
			a = getNthFib(n-1);
			calculated.put(n-1, a);
		}
		
		int b;
		if(calculated.containsKey(n - 2)){
			b = calculated.get(n - 2);
		} else {
			b = getNthFib(n-2);
			calculated.put(n-2, b);
		}
		
    return a + b;
  }
}
