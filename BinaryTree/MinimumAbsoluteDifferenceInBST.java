/**
 * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

    Example:

    Input:

        1
        \
            3
            /
            2

    Output:
    1

    Explanation:
    The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
    Note: There are at least two nodes in this BST.
 */

import java.util.List;
import java.util.ArrayList;

class MinimumAbsoluteDifferenceInBST {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int getMinimumDifference(TreeNode root) {
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