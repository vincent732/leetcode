/**
 * Given a binary tree, return all root-to-leaf paths.

    Note: A leaf is a node with no children.

    Example:

    Input:

       1
     /   \
    2     3
     \
      5

    Output: ["1->2->5", "1->3"]

    Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */

import java.util.*;

class BinaryTreePath {

    List<String> result = new ArrayList<String>();

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return result;
        }
        helper(root, String.valueOf(root.val));
        return result;
    }

    private void helper(TreeNode root, String str) {
        if (root.left == null && root.right == null) {
            result.add(str);
            return;
        }
        if (root.left != null) {
            helper(root.left, str + "->" + String.valueOf(root.left.val));
        }
        if (root.right != null) {
            helper(root.right, str + "->" + String.valueOf(root.right.val));
        }
    }
}