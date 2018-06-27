class Triangle {
    
    public int solution(int[] A) {
        // write your code in Java SE 8
        if (A.length < 3) {
            return 0;
        }
        Arrays.sort(A);
        // 1, 2, 5, 8, 10, 20
        if (A[A.length - 1] < 0) {
            return 0;
        }
        for (int i = 0 ; i < A.length ; i++) {
            for (int j = i + 1 ; j < A.length - 1 ; j++) {
                if (A[i] + A[j] > A[j + 1] && A[j] + A[j + 1] > A[i] &&
                A[i] + A[j+1] > A[j]) {
                    return 1;
                }
            }
        }
        return 0;
    }

}