import java.util.Arrays;
class CyclicRotation {
    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        if (A.length == 0 || K % A.length == 0) {
            return A;
        }
        if (K > A.length) {
            K %= A.length;
        }
        int N = A.length;
        int[] temp = Arrays.copyOfRange(A, N - K, N);
        for (int i = N - 1 ; i > K - 1 ; i--) {
            A[i] = A[i-K];
        }
        for (int i = 0; i < temp.length ; i++) {
            A[i] = temp[i];
        }
        return A;
    }

    public static void main(String[] args) {
        CyclicRotation c = new CyclicRotation();
        int[] a = c.solution(new int[]{5, -1000}, 1);
        for (int element : a) {
            System.out.print(element + " ");
        }
        System.out.println();

        a = c.solution(new int[]{3, 8, 9, 7, 6}, 3);
        for (int element : a) {
            System.out.print(element + " ");
        }

        System.out.println();
        
        a = c.solution(new int[]{1, 2, 3, 4}, 4);
        for (int element : a) {
            System.out.print(element + " ");
        }
        System.out.println();
        a = c.solution(new int[]{1, 2, 3, 4, 5, 6, 7}, 2);
        for (int element : a) {
            System.out.print(element + " ");
        }
    }
}