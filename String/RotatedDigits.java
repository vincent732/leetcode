class RotatedDigits {
    
    public int rotatedDigits(int N) {
        int cnt = 0;
        for (int i = 1; i <= N;i++) {
            boolean containsValideNum = false;
            boolean containsInvalidNum = false;
            int j = i;
            while (j != 0) {
                int mod = j % 10;
                if (mod == 2 || mod == 5 || mod == 6 || mod == 9) {
                    containsValideNum = true;
                } else if (mod == 3 || mod == 4 || mod == 7) {
                    containsInvalidNum = true;
                }
                j /= 10;
            }
            if (!containsInvalidNum && containsValideNum) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        RotatedDigits rd = new RotatedDigits();
        System.out.println(rd.rotatedDigits(857));
    }
}