/**
 * Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:
Input:

    2
   / \
  1   3

Output:
1
Example 2: 
Input:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

Output:
7
Note: You may assume the tree (i.e., the given root node) is not NULL.


 */

import java.util.*;

class FindBottomLeftTreeValue {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();

    public int findBottomLeftValue(TreeNode root) {
        ArrayList<Integer> path = new ArrayList<Integer>();
        path.add(root.val);
        traverse(root, path);
        int maxLength = Integer.MIN_VALUE;
        int leftValue = -1;
        for (int i = 0 ; i < paths.size() ; i++) {
            System.out.println(paths.get(i));
            if (paths.get(i).size() > maxLength) {
                maxLength = paths.get(i).size();
                leftValue = paths.get(i).get(maxLength - 1);
            }
        }
        return leftValue;
    }

    private void traverse(TreeNode root, ArrayList<Integer> currentPath) {
        if (root.left == null && root.right == null) {
            paths.add(currentPath);
            return;
        }
        if (root.left != null) {
            ArrayList<Integer> left = new ArrayList<Integer>(currentPath);
            left.add(root.left.val);
            traverse(root.left, left);
        }
        if (root.right != null) {
            ArrayList<Integer> right = new ArrayList<Integer>(currentPath);
            right.add(root.right.val);
            traverse(root.right, right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        FindBottomLeftTreeValue v = new FindBottomLeftTreeValue();
        System.out.println(v.findBottomLeftValue(root));
    }
}