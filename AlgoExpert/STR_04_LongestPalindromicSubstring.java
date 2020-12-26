import java.util.*;

/*
	If the lenght of the palindrome
		Is EVEN - the center is an empty string '' - DAAD
		Is ODD - the center is a character - DAD

	For each char in the string.
	1. Find the center by checking its neighbours to see if it matches one of the conditions (odd or even)
	2. If the neightbours are equal que iterate to find the new largest palindrome

	Corner case:
	What happens with cases like azzza or azzzzzz? - Check for bot cases (even and odd)

	TC O(n^2)
	SC O(n)
*/

class Program {
	public static String longestPalindromicSubstring(String str) {
		String longest = "";
		String potential = "";

		for (int i = 0; i<str.length(); i++) {
			int left = (i == 0) ? i : i - 1;
			int right = (i == str.length() - 1) ? i : i + 1;

			Character center = str.charAt(i);
			Character leftChar = str.charAt(left);
			Character rightChar = str.charAt(right);

			if (leftChar.equals(rightChar)) { // Odd size palindrome
				right = i + 1;
				potential = findPalindrome(str, left, right);
				if (potential.length() > longest.length()) longest = potential;

			}

			if (center.equals(leftChar)) { // Even size palindrome
				right = i;
				potential = findPalindrome(str, left, right);
				if (potential.length() > longest.length()) longest = potential;
			}
		}
		return longest;
	}

	public static String findPalindrome(String str, int left, int right) {
		int l = left;
		int r = right;

		while (l >= 0 && r<str.length() && str.charAt(l) == str.charAt(r)) {
			l--;
			r++;
		}
		return str.substring(l + 1, r);
	}

}