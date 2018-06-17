/**
 * Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".

Note:
The vowels does not include the letter "y".


 */
import java.util.*;

class ReverseVowelsOfAString {

    private boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }

    public String reverseVowels(String s) {

        List<Character> temp = new ArrayList<Character>();
        for (int i = 0 ; i < s.length() ; i++) {
            char c = s.charAt(i);
            if (isVowel(c)) {
                temp.add(c);
            }
        }

        int vowelIndex = temp.size() - 1;
        StringBuffer sb = new StringBuffer();
        for (int i = 0 ; i < s.length() ; i++) {
            char c = s.charAt(i);
            if (!isVowel(c)) {
                sb.append(c);
            } else {
                sb.append(temp.get(vowelIndex));
                vowelIndex--;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseVowelsOfAString r = new ReverseVowelsOfAString();
        System.out.println(r.reverseVowels("hello"));
    }
}