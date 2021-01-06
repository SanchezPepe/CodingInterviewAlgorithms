import java.util.*;

/**
	We sort each word in the array - this will be the key of out HashMap
	We map each key to a word in order to form the group anagrams
	We build the output List with the groups in the HashTable
	
	TC O(n * w * log(w)) - We travese the array once, read on HashMap is O(1) and we sort all the strings on it - O(w * log(w)) where 'w' is the length of the largest string.
	SC O(n) - We need to store a value for each word in order to get the group where it belongs to
*/

class Program {
  public static List<List<String>> groupAnagrams(List<String> words) {
    HashMap<String, List<String>> groups = new HashMap<>();
		
		for(String s : words){
			String key = sortString(s);
			
			if(groups.containsKey(key)){
				groups.get(key).add(s);
			} else {
				List<String> group = new ArrayList<String>();
				group.add(s);
				groups.put(key, group);
			}
		}
    return new ArrayList<>(groups.values());
  }
	
	public static String sortString(String word){
		char[] arr = word.toCharArray();
		Arrays.sort(arr);
		return new String(arr);	
	}
	
}
