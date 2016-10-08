import java.util.*;

class TreeNode{
    TreeNode left, right;
    int val;

    TreeNode(int x){
        this.val = x;
    }
}
public class Solution{
    void printFromTopToBottom(TreeNode root){
        if (root == null){
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
    }
}
