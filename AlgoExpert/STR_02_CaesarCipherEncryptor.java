import java.util.*;

class Program {
  public static String caesarCypherEncryptor(String str, int key) {

		if(key > 26) key = key % 26;
		if(key == 0) return str;

		StringBuilder ans = new StringBuilder();
		
		for(int i = 0; i < str.length(); i++){
			char c = str.charAt(i);
			int asciiValue = c + key;
			if(asciiValue > 122) 
				asciiValue = (asciiValue % 122) + 96;
			ans.append(Character.toString((char) asciiValue));
		}
		
    return ans.toString();
  }
}
