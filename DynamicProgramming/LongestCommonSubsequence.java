public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String a, String b) {
        int m = a.length();
        int n = b.length();
        return lcs(a, b , m, n);
    }

    private int lcs(String a, String b, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (a.charAt(m - 1) == b.charAt(n - 1)) {
            return 1 + lcs(a, b, m - 1, n - 1);
        }
        return max(lcs(a, b, m - 1, n), lcs(a, b, m, n - 1));
    }

    private int max(int i, int j) {
        return i > j ? i : j;
    }

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        System.out.println(lcs.longestCommonSubsequence("AGGTAB", "GXTXAYB"));
    }
}