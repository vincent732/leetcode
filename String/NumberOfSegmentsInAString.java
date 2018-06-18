/**
 * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.

Please note that the string does not contain any non-printable characters.

Example:

Input: "Hello, my name is John"
Output: 5

 */

class NumberOfSegmentsInAString {
    public int countSegments(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int cnt = 0;
        for (String str : s.split(" ")) {
            if ("".equals(str)) {
                continue;
            }
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        NumberOfSegmentsInAString n = new NumberOfSegmentsInAString();
        System.out.println(n.countSegments("Hello, my name is John"));
    }
}