/*
Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().


*/
class StrStr {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (needle.length() == 1) {
            return haystack.indexOf(needle);
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        int currentIndex = -1;
        int targetLength = needle.length();
        for (int i = 0 ; i < haystack.length();i++) {
            if (i + targetLength > haystack.length()) {
                break;
            }
            String subStr = haystack.substring(i, i+targetLength);
            if (subStr.equals(needle)) {
                currentIndex = i;
                break;
            }
        }
        return currentIndex;
    }

    public static void main(String[] args) {
        StrStr ss = new StrStr();
        System.out.println(ss.strStr("mississippi", "sippi"));
    }
}