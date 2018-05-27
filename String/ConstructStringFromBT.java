/**
 * You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.

The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.

Example 1:
Input: Binary tree: [1,2,3,4]
       1
     /   \
    2     3
   /    
  4     

Output: "1(2(4))(3)"

Explanation: Originallay it needs to be "1(2(4)())(3()())", 
but you need to omit all the unnecessary empty parenthesis pairs. 
And it will be "1(2(4))(3)".
Example 2:
Input: Binary tree: [1,2,3,null,4]
       1
     /   \
    2     3
     \  
      4 

Output: "1(2()(4))(3)"

Explanation: Almost the same as the first example, 
except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.

 */
class ConstructStringFromBT {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        // root
        sb.append(t.val);
        boolean appendLeft = false;
        boolean appendRight = false;
        if (t.right != null && t.left != null) {
            appendLeft = true;
            appendRight = true;
        } else if (t.right != null && t.left == null){
            appendLeft = true;
            appendRight = true;
        } else if (t.right == null && t.left != null) {
            appendLeft = true;
        }
        if (appendLeft) {
            // left node
            sb.append("(");
            sb.append(tree2str(t.left));
            sb.append(")");
        }
        if (appendRight) {
            // right node
            sb.append("(");
            sb.append(tree2str(t.right));
            sb.append(")");
        }
        return sb.toString();
    }
}