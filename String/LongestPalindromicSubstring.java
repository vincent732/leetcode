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
        int i = 0, j = s.length() - 1;
        int[][] dp = new int[1000][1000];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        int[][] record = new int[1000][1000];
        int maxLength = longestPalindrome(s, i, j, dp, record);
        System.out.println("Max Length:" + maxLength);
        return print(s, i, j, record);
    }

    private String print(String s, int i, int j, int[][] record) {
        if (i > j) {
            return "";
        }
        if (i == j) {
            return s.substring(i,i+1);
        }
        String result = "";
        if (record[i][j] == 0) {
            result = s.substring(i, i+1) + print(s, i + 1, j - 1, record) + s.substring(i, i + 1);
        } else if (record[i][j] == 1) {
            result = print(s, i + 1, j, record);
        } else {
            result = print(s, i, j - 1, record);
        }
        return result;
    }

    private int longestPalindrome(String s, int i, int j, int[][] dp, int[][] record) {
        if (i == j) {
            return 1;
        } 

        if (i > j) {
            return 0;
        } 
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = longestPalindrome(s, i + 1, j - 1, dp, record) + 2;
            record[i][j] = 0;
        } else if (longestPalindrome(s, i + 1, j, dp, record) > longestPalindrome(s, i, j - 1, dp, record)){
            dp[i][j] = longestPalindrome(s, i + 1, j, dp, record);
            record[i][j] = 1;
        } else if (longestPalindrome(s, i + 1, j, dp, record) < longestPalindrome(s, i, j - 1, dp, record)) {
            dp[i][j] = longestPalindrome(s, i, j - 1, dp, record);
            record[i][j] = 2;
        } else {
            dp[i][j] = longestPalindrome(s, i, j - 1, dp, record);
            record[i][j] = 3;
        }
        return dp[i][j];
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        System.out.println(lps.longestPalindrome("abcda"));
    }
}