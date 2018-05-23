import java.util.Arrays;

/*
Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:
Input: [2, 6, 4, 8, 10, 9, 15]
2, 4, 6, 8, 9, 10, 15
min(1, 7) ->1
max(1, 0) ->1

min(2, 7) -> 2
max(2, 0) -> 2
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Note:
Then length of the input array is in range [1, 10,000].
The input array may contain duplicates, so ascending order here means <=.
*/
class FindUnsortedSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int[] sorted_nums = nums.clone();
        Arrays.sort(sorted_nums);
        int start = nums.length;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sorted_nums[i] != nums[i]) {
                start = Math.min(i, start);
                end = Math.max(i, end);
            }
        }
        return (end - start >=0)? end-start+1:0;
    }

    public static void main(String[] args) {
        FindUnsortedSubarray fus = new FindUnsortedSubarray();
        int[] input = new int[]{2, 6, 4, 8, 10, 9, 15};
        System.out.println(fus.findUnsortedSubarray(input));
    }
}