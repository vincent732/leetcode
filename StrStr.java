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
        int start_index = -1;
        int next_index = -1;
        for (int i = 0; i < needle.length(); i++) {
            char c = needle.charAt(i);
            if (haystack.indexOf(c) < 0) {
                continue;
            }
            if (next_index == -1) {
                next_index = haystack.indexOf(c) + 1;
                start_index = haystack.indexOf(c);
                continue;
            }
            if (next_index == haystack.indexOf(c)) {
                next_index = haystack.indexOf(c) + 1;
            } else {
                start_index = -1;
                next_index = -1;
            }
        }
        return start_index;
    }

    public static void main(String[] args) {
        StrStr ss = new StrStr();
        System.out.println(ss.strStr("hello", "ll"));
    }
}