/**
 * Given a Binary Search Tree (BST) with the root node root, return the minimum difference between the values of any two different nodes in the tree.

    Example :

    Input: root = [4,2,6,1,3,null,null]
    Output: 1
    Explanation:
    Note that root is a TreeNode object, not an array.

    The given tree [4,2,6,1,3,null,null] is represented by the following diagram:

            4
            /   \
        2      6
        / \    
        1   3  

    while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also between node 3 and node 2.
    Note:

    The size of the BST will be between 2 and 100.
    The BST is always valid, each node's value is an integer, and each node's value is different.

 */

import java.util.List;
import java.util.ArrayList;
class MinimumDistanceBetweenBSTNodes {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    public int minDiffInBST(TreeNode root) {
        List<Integer> values = new ArrayList<Integer>();
        inOrder(root, values);

        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < values.size(); i++) {
            int diff = Math.abs(values.get(i) - values.get(i - 1));
            if (diff < minDiff) {
                minDiff = diff;
            }
        }
        return minDiff;
    }

    private void inOrder(TreeNode root, List<Integer> values) {
        if (root == null) {
            return;
        }
        inOrder(root.left, values);
        values.add(root.val);
        inOrder(root.right, values);
    }
}