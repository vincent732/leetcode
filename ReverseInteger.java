public class ReverseInteger {
    /*
    * Given an array, rotate the array to the right by k steps, where k is non-negative.
    *Example 1:

    Input: [1,2,3,4,5,6,7] and k = 3
    Output: [5,6,7,1,2,3,4]
    Explanation:
    rotate 1 steps to the right: [7,1,2,3,4,5,6]
    rotate 2 steps to the right: [6,7,1,2,3,4,5]
    rotate 3 steps to the right: [5,6,7,1,2,3,4]

    Example 2:

    Input: [-1,-100,3,99] and k = 2
    Output: [3,99,-1,-100]
    Explanation: 
    rotate 1 steps to the right: [99,-1,-100,3]
    rotate 2 steps to the right: [3,99,-1,-100]

    */
    public void rotate(int[] nums, int k) {
        if (nums.length == 1) {
            return;
        }
        int length = nums.length;
        int[] temp = new int[k = k > length ? k - length:k];
        int start_index = Math.abs(length -k);
        // store shifted element
        for (int i = 0; i < temp.length; i++) {
            temp[i] = nums[start_index];
            start_index++;
        }

        // shift them
        for (int i = length - k - 1; i >= 0; i--) {
            nums[i + k] = nums[i];
        }
        // fill the empty element
        for (int i = 0; i < temp.length; i++) {
            nums[i] = temp[i];
        }
    }

    public void rotate_2(int[] nums, int k) {
        while (k > 0) {
            int temp = nums[0];
            for (int i = 1;i < nums.length; i++) {
                int current = nums[i];
                nums[i] = temp;
                temp = current;
            }
            nums[0] = temp;
            k--;
        }
    }

    public static void main(String[] args) {
        ReverseInteger ri = new ReverseInteger();
        int[] input_array = new int[]{1,2,3,4,5,6,7};
        ri.rotate_2(input_array, 3);
    }
}