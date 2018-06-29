/**
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
Note:

1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.
Follow up:

Can you solve it in O(N) time and O(1) space?
 */
import java.util.Stack;
class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        if (S == null || T==null) {
            return false;
        }
        if (S.length() == 0 || T.length() == 0) {
            return false;
        }
        return helper(S).equals(helper(T));
    }

    private String helper(String str) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0 ; i < str.length() ; i++) {
            char c = str.charAt(i);
            if (c == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        BackspaceStringCompare b = new BackspaceStringCompare();
        System.out.println(b.backspaceCompare("ab##", "c#d#"));
        System.out.println(b.backspaceCompare("a#c", "b"));
        System.out.println(b.backspaceCompare("a##c", "#a#c"));
    }
}