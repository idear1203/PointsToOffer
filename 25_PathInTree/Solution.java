import java.util.*;

class TreeNode{
    TreeNode left, right;
    int val;
    public TreeNode(int x){
        this.val = x;
    }
}

public class Solution{
    public List<List<Integer>> findPath(TreeNode  root, int target){
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }

        helper(root, target, 0, result, new ArrayList<Integer>());
        return result;
    }

    private void helper(TreeNode root, int target, int sum, List<List<Integer>> result, List<Integer> path){
        sum += root.val;
        path.add(root.val);
        if (root.left == null && root.right == null){
            if (sum == target){
                result.add(new ArrayList<>(path));
            }
        } else {
            if (root.left != null){
                helper(root.left, target, sum, result, path);
            }

            if (root.right != null){
                helper(root.right, target, sum, result, path);
            }
        }

        sum -= root.val;
        path.remove(path.size() - 1);
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        TreeNode root = null;
        int target = 0;

        // Case: null
        List<List<Integer>> result = sol.findPath(root, target);
        System.out.println("Case: null");
        for (List<Integer> path : result){
            System.out.println(path.toString());
        }

        // Case: more than one path meets demand.
        // Prepare data.
        root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(12);
        target = 22;

        result = sol.findPath(root, target);
        System.out.println("Case: more than one path meets demand");
        for (List<Integer> path : result){
            System.out.println(path.toString());
        }
    }
}
