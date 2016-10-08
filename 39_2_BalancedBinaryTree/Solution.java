class TreeNode{
    TreeNode left, right;
    int val;
    TreeNode(int x){
        this.val = x;
    }
}

public class Solution{
    public boolean isBalanced(TreeNode root){
        return isBalancedHelper(root) >= 0;
    }

    public int isBalancedHelper(TreeNode root){
        if (root == null){
            return 0;
        }

        int left = isBalancedHelper(root.left);
        int right = isBalancedHelper(root.right);
        if (left < 0 || right < 0 || Math.abs(left - right) > 1){
            return -1;
        }

        return Math.max(left, right) + 1;
    }
}
