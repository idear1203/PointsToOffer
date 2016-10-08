class TreeNode{
  TreeNode left, right;
  int val;
  public TreeNode(int x){
    this.val = x;
  }
}

public class Solution{
  void mirrorRecursively(TreeNode root){
    if (root == null){
      return;
    }

    TreeNode tmp = root.left;
    root.left = root.right;
    root.right = tmp;
    mirrorRecursively(root.left);
    mirrorRecursively(root.right);
  }
}
