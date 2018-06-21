import java.util.Arrays;
class MissingInteger {
    public int solution(int[] A) {
        // write your code in Java SE 8
        if (A.length == 0) {
            return 1;
        }
        
        if (A.length == 1 && (A[0] <= 0 || A[0] > 1)) {
            return 1;
        }
        
        Arrays.sort(A);
        if (A[A.length - 1] <= 0 || A[0] > 1) {
            return 1;
        }
        int plusIndex = -1;
        for (int i = 0 ; i < A.length - 1 ; i++) {
            if (A[i] < 0 && A[i+1] > 0) {
                plusIndex = i+1;
                break;
            }
        }
        if (plusIndex != -1) {
            return solution(Arrays.copyOfRange(A, plusIndex, A.length));
        }
        
        for (int i = 0 ; i < A.length - 1 ; i++) {
            if (A[i+1] - A[i] > 1) {
                return A[i] + 1;
            }
        }
        return A[A.length - 1] + 1;
    }
}