/**
 * Given a binary tree, return the inorder traversal of its nodes' values.

    Example:

    Input: [1,null,2,3]
    1
        \
        2
        /
    3

    Output: [1,3,2]

 */
import java.util.List;
import java.util.ArrayList;

class BinaryTreeInorderTraversal {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<Integer>();
        inOrder(root, output);
        return output;
    }
    
    private void inOrder(TreeNode root, List<Integer> output) {
        if (root == null) {
            return;
        }

        inOrder(root.left, output);
        output.add(root.val);
        inOrder(root.right, output);
    }
}