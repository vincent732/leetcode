/**
 * 
 * Given a binary tree, return the tilt of the whole tree.

    The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values. Null node has tilt 0.

    The tilt of the whole tree is defined as the sum of all nodes' tilt.

    Example:
    Input: 
              1
            /   \
           2     3
    Output: 1
    Explanation: 
    Tilt of node 2 : 0
    Tilt of node 3 : 0
    Tilt of node 1 : |2-3| = 1
    Tilt of binary tree : 0 + 0 + 1 = 1
    Note:

    The sum of node values in any subtree won't exceed the range of 32-bit integer.
    All the tilt values won't exceed the range of 32-bit integer.
 */

class BinaryTreeTilt {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 0;
        }
        int tilt = Math.abs((root.left == null ? 0:root.left.val) - (root.right == null ? 0:root.right.val));
        return findTilt(root.left) + findTilt(root.right) + tilt;
    }

}