/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

    For example:
    Given binary tree [3,9,20,null,null,15,7],
        3
    / \
    9  20
        /  \
    15   7
    return its level order traversal as:
    [
    [3],
    [9,20],
    [15,7]
    ]
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class BinaryTreeLevelOrderTraversal {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> layer = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                layer.add(temp.val);
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            result.add(layer);
        }
        return result;
    }
}