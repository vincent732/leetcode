/**
 * for solving this problem. 
 * The heights of the nails are given as elements of a non-empty zero-indexed array A consisting of N integers, sorted in a non-decreasing order.This function, when given the array A and integer K, returns the maximal number of nails that can be positioned at the same height.

For example, given K = 2 and array A consisting of ten elements such that:

  A[0] = 1
  A[1] = 1
  A[2] = 3
  A[3] = 3
  A[4] = 3
  A[5] = 4
  A[6] = 5
  A[7] = 5
  A[8] = 5
  A[9] = 5
the function should return 5. 
One of the possibilities is to hammer the nails represented by A[8] and A[9] down to height 3.

Unfortunately, despite the fact that the function may return the expected result for the example input, 
there is a bug (or bugs) in the implementation, 
which may produce incorrect results for other inputs. 
Find the bug(s) and correct them. 
You should modify at most four lines of code.
 */
class MaxNailHeight {
    public int solution(int[] A, int K) {
        int n = A.length;
        if (K >= A.length)return A.length;// base case
        int best = 1; // change best to 1
        int count = 1;
        for (int i = 0 ; i < n - K - 1; i++) {
            if (A[i] == A[i+1]) {
                count = count + 1;
            } else {
                count = 1; // change count to 1
            }
            if (count > best) {
                best = count;
            }
        }
        int result = best + K; // change from best + K + 1 to best + K
        return result;
    }

    public static void main(String[] args) {
        MaxNailHeight m = new MaxNailHeight();
        System.out.println(m.solution(new int[]{1,1,3,3,3,4,5,5,5,5}, 2));
        System.out.println(m.solution(new int[]{1,1,3,4}, 2));
        System.out.println(m.solution(new int[]{1,1,1,1}, 2));
        System.out.println(m.solution(new int[]{1,1}, 2));
        System.out.println(m.solution(new int[]{1, 2, 2, 2, 2}, 5));
        System.out.println(m.solution(new int[]{1, 2, 2, 2, 2}, 6));
    }
}