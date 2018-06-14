/**
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. 
 * A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

    Example 1:
    Given tree s:

        3
        / \
    4   5
    / \
    1   2
    Given tree t:
    4 
    / \
    1   2
    Return true, because t has the same structure and node values with a subtree of s.
    Example 2:
    Given tree s:

         3
        / \
       4   5
      / \
     1   2
         /
        0
    Given tree t:
    4
    / \
    1   2
    Return false.
 */

class SubtreeOfAnotherTree {

    StringBuffer nodes = new StringBuffer();
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        if (isSameTree(s, t) || isSameTree(s.left, t) || isSameTree(s.right, t)) {
            return true;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        
        if (p.val != q.val || 
            (!isSameTree(p.left, q.left) || !isSameTree(p.right, q.right))) {
            return false;
        }
        return true;
    }
}