/**
 * 
 * Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. 
 * If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
Example:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Restrictions:
The string consists of lower English letters only.
Length of the given string and k will in the range [1, 10000]

 */

 class ReverseStringII {
    public String reverseStr(String s, int k) {
        if (s.length() <= k) {
            return reverseStr(s);
        }
        int i = 0;
        int j = (2 * k - 1 < s.length() - 1) ? 2 * k - 1 : s.length() - 1;
        StringBuffer sb = new StringBuffer();

        while (j < s.length() && i < s.length()) {
            System.out.println(i + ":" + j);
            sb.append(reverseStr(s.substring(i, i + k)));
            sb.append(s.substring(i + k, j + 1));
            if (s.length() - 1 - (j + 1) + 1 < k) { // if number of remaining chars is smaller than k
                sb.append(reverseStr(s.substring(j+1, s.length())));
                break;
            }
            i = j + 1;
            j = (j + 2 * k < s.length()) ? j + 2 * k : s.length() - 1;
        }
        return sb.toString();
    }

    private String reverseStr(String s) {
        if (s.length() == 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        sb.append(reverseStr(s.substring(1, s.length())));
        sb.append(s.charAt(0));
        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseStringII r = new ReverseStringII();
        System.out.println(r.reverseStr("hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl", 39));
    }
}