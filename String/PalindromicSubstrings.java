/**
 * Given a string, your task is to count how many palindromic substrings in this string.

    The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

    Example 1:
    Input: "abc"
    Output: 3
    Explanation: Three palindromic strings: "a", "b", "c".
    Example 2:
    Input: "aaa"
    Output: 6
    Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
    Note:
    The input string length won't exceed 1000
 */

class PalindromicSubstrings {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int cnt = 0;
        for (int i = 0 ; i < s.length() ; i++) {
            for (int j = 2 ; i + j <= s.length() ; j++) {
                String str = s.substring(i, i + j);
                if (valuePalindromic(str)) {
                    cnt++;
                }
            }
        }
        return cnt + s.length();
    }

    private boolean valuePalindromic(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }

        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromicSubstrings p = new PalindromicSubstrings();
        System.out.println(p.countSubstrings("str"));
        System.out.println(p.countSubstrings("aaa"));
        System.out.println(p.countSubstrings("aba"));
    }
}