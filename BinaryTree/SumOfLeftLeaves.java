/**
 * 
 * Find the sum of all left leaves in a given binary tree.

    Example:

        3
        / \
        9  20
        /  \
        15   7

    There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */

class SumOfLeftLeaves {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return inorder(root, false);
    }

    private int inorder(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {//is a left node
            if (isLeft) {
                return root.val;
            } else {
                return 0;
            }
        }
        return inorder(root.left, true) + inorder(root.right, false);
    }
}