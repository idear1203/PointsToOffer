class TreeNode{
    TreeNode left, right;
    int val;
    TreeNode(int x){
        this.val = x;
    }
}

public class Solution{
    public int treeDepth(TreeNode root){
        if (root == null){
            return 0;
        }

        return Math.max(treeDepth(root.left), treeDepth(root.right)) + 1;
    }
}
