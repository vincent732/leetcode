import java.util.ArrayList;

/**
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */
public class ReverseWords {

    public String reverseWords(String s) {
        StringBuilder sentence = new StringBuilder();
        String[] str = s.split(" ");
        for(int i = 0; i < str.length;i++) {
            sentence.append(reverseSingleWords(str[i]));
            if (i < str.length - 1) {
                sentence.append(" ");
            }
        }
        return sentence.toString();
    }

    private String reverseSingleWords(String s) {
        StringBuilder str = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            str.append(c);
        }
        return str.toString();
    }

    public static void main(String[] args) {
        ReverseWords rw = new ReverseWords();
        System.out.println(rw.reverseWords("Let's take LeetCode contest"));
    }
}