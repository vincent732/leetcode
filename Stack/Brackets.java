/**
 * A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:

S is empty;
S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
S has the form "VW" where V and W are properly nested strings.
For example, the string "{[()()]}" is properly nested but "([)()]" is not.

Write a function:

class Solution { public int solution(String S); }
that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.

For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.

Assume that:

N is an integer within the range [0..200,000];
string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N) (not counting the storage required for input arguments).

 */
import java.util.Stack;
import java.util.List;
import java.util.Arrays;
public class Brackets {

    public int solution(String S) {
        if (S != null && S.isEmpty()) {
            return 1;
        }
        List<Character> rightBracket = Arrays.asList(']', '}', ')');
        List<Character> leftBracket = Arrays.asList('[', '{', '(');
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0 ; i < S.length() ; i++) {
            char c = S.charAt(i);
            if (leftBracket.contains(c)) {
                stack.push(c);
                continue;
            }
            if (rightBracket.contains(c)) {
                int idx = rightBracket.indexOf(c);
                if (stack.isEmpty()) {
                    return 0;
                }
                if (stack.peek() == leftBracket.get(idx)) {
                    stack.pop();
                    continue;
                }
            }
            break;
        }
        return (stack.isEmpty()) ? 1:0;
    }

    public static void main(String[] args) {
        Brackets b = new Brackets();
        System.out.println(b.solution("{[()()]}"));
        System.out.println(b.solution("([)()]"));
        System.out.println(b.solution("())"));
    }
}