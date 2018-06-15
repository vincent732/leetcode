/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22
 */

import java.util.*;

class PathSum {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    boolean flag = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        helper(root, root.val, sum);
        return flag;
    }

    private void helper(TreeNode root, int sum, int targetSum) {
        if (root == null || flag) {
            return;
        }

        if (root.left == null && root.right == null) {
            if (sum == targetSum) {
                flag = true;
            }
            return;
        }

        if (root.left != null) {
            helper(root.left, sum + root.left.val, targetSum);
        }

        if (root.right != null) {
            helper(root.right, sum + root.right.val, targetSum);
        }
    }
}