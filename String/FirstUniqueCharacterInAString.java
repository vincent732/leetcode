/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.

 */
import java.util.*;

class FirstUniqueCharacterInAString {

    Map<Character, Integer> output = new LinkedHashMap<Character, Integer>();
    public int firstUniqChar(String s) {
        if (s.length() == 0) {
            return -1;
        }
        if (s.length() == 1) {
            return 0;
        }
        for (int i = 0 ; i < s.length(); i++) {
            char c = s.charAt(i);
            if (output.containsKey(c)) {
                output.put(c, output.get(c) + 1);
            } else {
                output.put(c, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : output.entrySet()) {
            if (entry.getValue() == 1) {
                return s.indexOf(entry.getKey());
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstUniqueCharacterInAString f = new FirstUniqueCharacterInAString();
        System.out.println(f.firstUniqChar("loveleetcode"));
    }
}