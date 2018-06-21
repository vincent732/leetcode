import java.util.Arrays;

class NonDecreasingArrayII {
    public boolean checkPossibility(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);
        int cnt = 0;
        for (int i = 0 ; i < nums.length ; i++) {
            if (nums[i] != temp[i]) {
                if (cnt > 1) {
                    return false;
                }
                cnt++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NonDecreasingArrayII n = new NonDecreasingArrayII();
        System.out.println(n.checkPossibility(new int[]{1, 3, 3, 5, 2}));
        System.out.println(n.checkPossibility(new int[]{1}));
        System.out.println(n.checkPossibility(new int[]{3, 1}));

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE + 1);
        System.out.println(Integer.MAX_VALUE + 2);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MIN_VALUE + 1);
    }
}