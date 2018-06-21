import java.util.Arrays;

public class PermMissingElem {
    public int solution(int[] A) {
        Arrays.sort(A);

        for (int i = 0 ; i < A.length - 1 ; i++) {
            if (A[i+1] - A[i] > 1) {
                return A[i] + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        PermMissingElem p = new PermMissingElem();
        System.out.println(p.solution(new int[]{2,3,1,4,6,7}));
    }
}