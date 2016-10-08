class TreeNode{
    TreeNode left, right;
    int val;

    public TreeNode(int x){
        this.val = x;
    }
}

public class Solution{

    // Record the most recent visited node in traversal.
    private TreeNode last;

    public TreeNode convert(TreeNode root){
        if (root == null){
            return null;
        }

        TreeNode head = null;
        if (root.left != null){
            head = convert(root.left);
            last.right = root;
            root.left = last;
        } else {
            head = root;
        }

        // Update `last`
        last = root;
        if (root.right != null){
            root.right = convert(root.right);
            root.right.left = root;
        }

        return head;
    }

    public static void main(String args[]){
        Solution sol = null;
        TreeNode root = null;
        TreeNode head = null;

        // Case 1: null
        root = null;
        sol = new Solution();
        head = sol.convert(root);
        printDeLinkedList(head);

        // Case 2: all nodes of tree contains only left child.
        root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.left.left = new TreeNode(4);
        sol = new Solution();
        head = sol.convert(root);
        printDeLinkedList(head);

        // Case 3: all nodes of tree contains only right child.
        root = new TreeNode(10);
        root.right = new TreeNode(14);
        root.right.right = new TreeNode(16);
        sol = new Solution();
        head = sol.convert(root);
        printDeLinkedList(head);

        // Case 4: complete binary search tree.
        root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.right = new TreeNode(14);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(16);
        sol = new Solution();
        head = sol.convert(root);
        printDeLinkedList(head);
    }

    private static void printDeLinkedList(TreeNode head){
        StringBuilder sb = new StringBuilder();
        for (TreeNode curNode = head; curNode != null; curNode = curNode.right){
            sb.append(String.format("Node: %s\n", getLabel(curNode)));
            sb.append(String.format("Prev: %s\n", getLabel(curNode.left)));
            sb.append(String.format("Next: %s\n", getLabel(curNode.right)));
        }

        System.out.println(sb.toString());
    }

    private static String getLabel(TreeNode node){
        return node == null ? "null" : String.valueOf(node.val);
    }
}
