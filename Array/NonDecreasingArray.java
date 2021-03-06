class NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        int count = 1;
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (count == 0)  {
                    return false;
                }
                if (i == 1 || nums[i] >= nums[i-2]) {
                    nums[i-1] = nums[i];
                } else {
                    nums[i] = nums[i-1];
                }
                count--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NonDecreasingArray n = new NonDecreasingArray();
        System.out.println(n.checkPossibility(new int[]{1, 5, 3, 3, 7}));
    }
}