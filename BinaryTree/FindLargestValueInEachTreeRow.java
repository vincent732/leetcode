/**
 * You need to find the largest value in each row of a binary tree.

    Example:
    Input: 

             1
            / \
            3   2
           / \   \  
          5   3   9 

    Output: [1, 3, 9]
 */
import java.util.*;
public class FindLargestValueInEachTreeRow {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    private Map<Integer, Integer> cnts = new HashMap<Integer, Integer>();
    public List<Integer> largestValues(TreeNode root) {
        if(root == null) {
            return new ArrayList<Integer>();
        }
        cnts.put(1, root.val);
        traverse(root.left, 2);
        traverse(root.right, 2);
        return new ArrayList<Integer>(cnts.values());
    }

    private void traverse(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (cnts.containsKey(level)) {
            int currentMaxValue = cnts.get(level);
            if (currentMaxValue < root.val) {
                cnts.put(level, root.val);
            }
        } else {
            cnts.put(level, root.val);
        }
        traverse(root.left, level + 1);
        traverse(root.right, level + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        FindLargestValueInEachTreeRow f = new FindLargestValueInEachTreeRow();
        System.out.println(f.largestValues(root));
    }
}