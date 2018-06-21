
class OddOccurrencesInArray {
    public int solution(int[] A) {
        // write your code in Java SE 8
        if (A.length == 1) {
            return A[0];
        }
        int unpair = A[0];
        for (int i = 1 ; i < A.length ; i++) {
            unpair ^= A[i];
        }
        return unpair;
    }

    public static void main(String[] args) {
        OddOccurrencesInArray o = new OddOccurrencesInArray();
        System.out.println(o.solution(new int[]{9,3,9,3,9,7,9}));
        System.out.println(o.solution(new int[]{0,0,0,0,0,0,0}));
    }
}