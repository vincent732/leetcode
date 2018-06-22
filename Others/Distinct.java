/**
 * Write a function

class Solution { public int solution(int[] A); }
that, given an array A consisting of N integers, returns the number of distinct values in array A.

Assume that:

N is an integer within the range [0..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
For example, given array A consisting of six elements such that:

 A[0] = 2    A[1] = 1    A[2] = 1
 A[3] = 2    A[4] = 3    A[5] = 1
the function should return 3, because there are 3 distinct values appearing in array A, namely 1, 2 and 3.

Complexity:

expected worst-case time complexity is O(N*log(N));
expected worst-case space complexity is O(N) (not counting the storage required for input arguments).

 */

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class Distinct {
    public int solution(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();

        for (int i = 0; i < A.length ; i++) {
            if (counts.containsKey(A[i])) {
                counts.put(A[i], counts.get(A[i]) + 1);
            } else {
                counts.put(A[i], 1);
            }
        }
        return counts.size();
    }

    public static void main(String[] args) {
        Distinct d = new Distinct();
        System.out.println(d.solution(new int[]{2,1,1,2,3,1}));
    }
}