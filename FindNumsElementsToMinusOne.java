class FindNumsElementsToMinusOne {

    public int findNumsElementsToMinusOne(int[] arr) {
        int count = 0;
        for (int i : arr) {
            if (i != -1) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    public int countPerfectSquare(int a, int b) {
        int cnt = 0;
        for (int i = a; i <= b ; i++) {

            for (int j = 1; j * j <= i; j++) {
                if (j * j == i) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        FindNumsElementsToMinusOne fnetm = new FindNumsElementsToMinusOne();
        System.out.println(fnetm.countPerfectSquare(10, 24));
    }
}