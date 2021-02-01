import java.util.*;

/**
	We declare 3 nested for loops.
	For each loop we iterate and look for a valid IP number (0-255),
	If we don't find a valid number, we backtrack, move the point to the right and look for the next number.
	Once we find a valid number X, we nest a loop inside to look for next valid number and so on until we reach the end of the string

	TC - O(1): We are guaranteed a fixed length string that will have at least 1 digit and at most 16 digits
	SC - O(1): We have a max num of valid IP addreses = 2^(32) - (worst case scenario)

**/

class Program {

    public ArrayList<String> validIPAddresses(String string) {
        ArrayList<String> found = new ArrayList<String> ();

        for (int i = 1; i<Math.min(string.length(), 4); i++) {
            String currentParts[] = new String[4];

            currentParts[0] = string.substring(0, i);
            if (!isValidPart(currentParts[0])) {
                continue;
            }

            for (int j = i + 1; j<i + Math.min(string.length() - i, 4); j++) {
                currentParts[1] = string.substring(i, j);
                if (!isValidPart(currentParts[1])) {
                    continue;
                }

                for (int k = j + 1; k<j + Math.min(string.length() - j, 4); k++) {
                    currentParts[2] = string.substring(j, k);
                    currentParts[3] = string.substring(k);

                    if (isValidPart(currentParts[2]) && isValidPart(currentParts[3])) {
                        found.add(String.join(".", currentParts));
                    }
                }
            }
        }
        return found;
    }

    public boolean isValidPart(String s) {

        int num = Integer.parseInt(s);
        if (num > 255) return false;

        return s.length() == String.valueOf(num).length(); // check for leading 0's
    }

}
