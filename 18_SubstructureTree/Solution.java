class TreeNode{
  TreeNode left, right;
  int val;
  public TreeNode(int x){
    this.val = x;
  }
}

public class Solution{
  public boolean isSubTree(TreeNode node1, TreeNode node2){
    if (node2 == null){
      return true;
    }

    if (node1 == null){
      return false;
    }

    if (node1.val == node2.val){
      boolean result =  hasSubTree(node1, node2);
      if (result){
        return true; 
      }
    }

    return isSubTree(node1.left, node2) || isSubTree(node1.right, node2);
  }

  private boolean hasSubTree(TreeNode node1, TreeNode node2){
    if (node2 == null){
      return true;
    }

    if (node1 == null){
      return false;
    }

    return node1.val == node2.val 
      && hasSubTree(node1.left, node2.left) 
      && hasSubTree(node1.right, node2.right);
  }
}
