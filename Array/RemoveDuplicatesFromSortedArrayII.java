/**
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:

Given nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.

It doesn't matter what you leave beyond the returned length.
Example 2:

Given nums = [0,0,1,1,1,1,2,3,3],

Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.

It doesn't matter what values are set beyond the returned length.

 */

class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int prev = 1;
        int cur = 2;
        while (prev < nums.length && cur < nums.length) {
            if (nums[cur] == nums[prev] && nums[cur] == nums[prev - 1]) {
                cur++;
            } else {
                prev++;
                nums[prev] = nums[cur];
                cur++;
            }
        }
        return prev + 1;
    }

    public static void main(String[] args) {
        int[] num = new int[]{0,0,1,1,1,1,2,3,3};
        RemoveDuplicatesFromSortedArrayII r = new RemoveDuplicatesFromSortedArrayII();
        System.out.println(r.removeDuplicates(num));
        for (int n : num) {
            System.out.print(n+" ");
        }
    }
}