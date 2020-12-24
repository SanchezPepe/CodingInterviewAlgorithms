import java.util.*;

/*
	This can be solved by traversing the string just once.
	We need to create a counter = 0
	Taking a = a[i] and b = a[i+1] if a == b there are two possible options:
		1. If counter == 9, we need to add "9/a[i]/" and reset the counter to 0
		2. If counter < 8, we increment counter by 1 and move to the next letter.
	If a != b means we need to encode the characters with its number of occurences and reset it.
	
	TC. O(n)
	SC. O(2n) => O(n)
*/

class Program {
  public String runLengthEncoding(String string) {
    int counter = 1;
		StringBuilder ans = new StringBuilder();
		char prev = string.charAt(0);
		for(int i = 1; i < string.length(); i++){
			char actual = string.charAt(i);			
			if(counter == 9 || prev != actual){ //encode the character
				ans.append(counter + String.valueOf(prev));
				counter = 1;
			} else {
				counter++;
			}
			prev = string.charAt(i);
		}
		//Add the last encoding bcs it's not handled in the for loop
		ans.append(counter + String.valueOf(prev));

    return ans.toString();
  }
}
