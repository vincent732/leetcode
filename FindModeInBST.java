/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;

public class FindModeInBST {
    int count = -1;
    int maxCount = 0;
    int lastVal = Integer.MAX_VALUE;
    ArrayList<Integer> list = new ArrayList<>();
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int[] findMode(TreeNode root) {
        find(root);
        if (count > maxCount) {
            list.clear();
            list.add(lastVal);
        } else if (count == maxCount) {
            list.add(lastVal);
        }

        int[] result = new int[list.size()];
        for(int i = 0;i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private void find(TreeNode root) {
        if(root == null) {
            return;
        }
        find(root.left);
        if (root.val != lastVal) {
            if (count > maxCount) {
                maxCount = count;
                list.clear();
                list.add(lastVal);
            } else if (count == maxCount) {
                list.add(lastVal);
            }
            count = 1;
            lastVal = root.val;
        } else {
            count++;
        }
        find(root.right);
    }
}