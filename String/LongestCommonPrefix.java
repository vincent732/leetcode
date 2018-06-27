/**
 * Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.
 */
class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < strs[0].length() ; i++ ) {
            char curChar = strs[0].charAt(i);
            boolean flag = true;
            for (int j = 1 ; j < strs.length ; j++ ) {
                if (i > strs[j].length() - 1) {
                    flag = false;
                    break;
                }
                if (strs[j].charAt(i) != curChar) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                sb.append(curChar);
            } else {
                break;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LongestCommonPrefix l = new LongestCommonPrefix();
        System.out.println(l.longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(l.longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }
}