import java.util.Arrays;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

    Example 1:

    Input: "babad"
    Output: "bab"
    Note: "aba" is also a valid answer.
    Example 2:

    Input: "cbbd"
    Output: "bb"

 */
class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if (s.length() <= 0) {
            return s;
        }
        int n = s.length();
        boolean[][] table = new boolean[n][n];
        for (boolean[] t : table) {
            Arrays.fill(t, false);
        }
        int maxLength = 0;
        int start = 0;
        for (int i = 0;i < n; i++) {
            table[i][i] = true;
            maxLength = 1;
        }

        for (int i = 0;i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                table[i][i+1] = true;
                start = i;
                maxLength = 2; 
            }
        }

        for (int k = 3; k <= n; k++) {
            for (int i = 0;i < n - k + 1; i++) {
                int j = i + k - 1;
                if (table[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    table[i][j] = true;

                    if (k > maxLength) {
                        maxLength = k;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + maxLength);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        System.out.println(lps.longestPalindrome("babad"));
    }
}