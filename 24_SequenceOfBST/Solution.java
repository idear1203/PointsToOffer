import java.util.*;

public class Solution{
    public boolean verifySequenceOfBST(int[] sequence){
        return helper(sequence, 0, sequence.length - 1);
    }

    private boolean helper(int[] sequence, int start, int end){
        //
        // Empty tree and tree with single node is binary search tree
        //
        if (start >= end){
            return true;
        }

        int root = sequence[end];

        //
        // Find first element larger than root
        //
        int rightStart = end;
        for (int i = start; i < end; i++){
            if (sequence[i] > root){
                rightStart = i;
                break;
            }
        }

        //
        // Elements in right sub tree should not be less than root.
        //
        for (int i = rightStart; i < end; i++){
            if (sequence[i] < root){
                return false;
            }
        }

        return helper(sequence, start, rightStart - 1)
            && helper(sequence, rightStart, end - 1);
    }

    public static void main(String[] args){
        int[] sequence = null;
        Solution sol = new Solution();

        // Empty tree
        sequence = new int[0];
        System.out.println(Arrays.toString(sequence));
        System.out.println(sol.verifySequenceOfBST(sequence));

        // Tree with a single node
        sequence = new int[]{1};
        System.out.println(Arrays.toString(sequence));
        System.out.println(sol.verifySequenceOfBST(sequence));
        
        // Tree only has left sub-tree
        sequence = new int[]{5, 6, 8};
        System.out.println(Arrays.toString(sequence));
        System.out.println(sol.verifySequenceOfBST(sequence));
        
        // Tree only has right sub-tree
        sequence = new int[]{8, 10, 11};
        System.out.println(Arrays.toString(sequence));
        System.out.println(sol.verifySequenceOfBST(sequence));
        
        // Complete binary search tree
        sequence = new int[]{5, 7, 6, 9, 11, 10, 8};
        System.out.println(Arrays.toString(sequence));
        System.out.println(sol.verifySequenceOfBST(sequence));
        
        // False expected.
        sequence = new int[]{7, 4, 6, 5};
        System.out.println(Arrays.toString(sequence));
        System.out.println(sol.verifySequenceOfBST(sequence));
    }
}
