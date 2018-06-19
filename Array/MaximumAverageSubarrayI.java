import java.util.Arrays;

/**
 * Given an array consisting of n integers, 
 * find the contiguous subarray of given length k that has the maximum average value. 
 * And you need to output the maximum average value.

    Example 1:
    Input: [1,12,-5,-6,50,3], k = 4
    Output: 12.75
    Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
    Note:
    1 <= k <= n <= 30,000.
    Elements of the given array will be in the range [-10,000, 10,000].

 */

class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        if (k > nums.length) {
            return 0.0;
        }
        int cur = 0;
        for (int i = 0 ; i < k ; i++) {
            cur+=nums[i];
        }
        int max = cur;
        for (int i = 1 ; i <= nums.length - k; i++) {
            cur = cur - nums[i - 1] + nums[k + i -1];
            if (cur > max) {
                max = cur;
            }
        }
        return Double.valueOf(max) / k;
    }

    public static void main(String[] args) {
        MaximumAverageSubarrayI m = new MaximumAverageSubarrayI();
        System.out.println(m.findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
    }
}