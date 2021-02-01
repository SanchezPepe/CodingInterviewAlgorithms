import java.util.*;

class Program {
    public static boolean isPalindrome(String str) {
        //Pointers
        int start = 0;
        int end = str.length() - 1;

        while (start<end) {
            if (str.charAt(start) != str.charAt(end))
                return false;

            start++;
            end--;
        }

        return true;
    }
}