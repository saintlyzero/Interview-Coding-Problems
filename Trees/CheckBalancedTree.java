/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BalancedWithHeight{
    int height;
    boolean balanced;
    
    BalancedWithHeight(int height, boolean balanced){
        this.height = height;
        this.balanced = balanced;
    }
}
class Solution {
    public boolean isBalanced(TreeNode root) {
        return checkBalanced(root).balanced;
    }
    
    BalancedWithHeight checkBalanced(TreeNode root){
        
        if (root == null)
            return new BalancedWithHeight(-1, true);
        
        BalancedWithHeight leftResult = checkBalanced(root.left);
        if( !leftResult.balanced ){
            return leftResult;
        }
        
        BalancedWithHeight rightResult = checkBalanced(root.right);
        if( !rightResult.balanced ){
            return rightResult;
        }
        
        boolean is_balanced = Math.abs(leftResult.height - rightResult.height) <=  1;
        int height = Math.max(leftResult.height, rightResult.height) + 1;
        
        return new BalancedWithHeight(height, is_balanced);
    }
}
