/**
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

    Example 1:
    Input: "aba"
    Output: True
    Example 2:
    Input: "abca"
    Output: True
    Explanation: You could delete the character 'c'.
    Note:
    The string will only contain lowercase characters a-z. The maximum length of the string is 50000.

    abcda
 */
class ValidPalindromeII {
    int cnt = 0;
    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
                continue;
            }
            if (cnt < 1) {
                cnt++;
                if (j - i == 1) {
                    return true;
                }
                String left = s.substring(i, j);
                String right = s.substring(i+1, j+1 == s.length() ? s.length() : j+1);
                return validPalindrome(left) || validPalindrome(right);
            } else {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindromeII v = new ValidPalindromeII();
        System.out.println(v.validPalindrome("aba"));
        System.out.println(v.validPalindrome("abca"));
        System.out.println(v.validPalindrome("abcba"));
        System.out.println(v.validPalindrome("acbda"));
    }
}