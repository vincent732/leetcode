import java.util.Arrays;

/**
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

The root is the maximum number in the array.
The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
Construct the maximum tree by the given array and output the root node of this tree.

Example 1:
Input: [3,2,1,6,0,5]
Output: return the tree root node representing the following tree:

      6
    /   \
   3     5
    \    / 
     2  0   
       \
        1
Note:
The size of the given array will be in the range [1,1000].

 */

class MaximumBinaryTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int maxIdx = findMaxIdx(nums);
        TreeNode root = new TreeNode(nums[maxIdx]);
        int[] leftArr = Arrays.copyOfRange(nums, 0, maxIdx);
        int[] rightArr = Arrays.copyOfRange(nums, maxIdx + 1, nums.length);
        root.left = constructMaximumBinaryTree(leftArr);
        root.right = constructMaximumBinaryTree(rightArr);
        return root;
    }

    private int findMaxIdx(int[] nums) {
        int max = Integer.MIN_VALUE;
        int idx = -1;
        for (int i = 0 ; i < nums.length ; i++) {
            if (nums[i] > max) {
                max = nums[i];
                idx = i;
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        MaximumBinaryTree m = new MaximumBinaryTree();
        m.constructMaximumBinaryTree(new int[]{3,2,1,6,0,5});
    }
}