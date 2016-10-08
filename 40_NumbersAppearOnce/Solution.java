import java.util.*;

public class Solution{
    public List<Integer> findNumsAppearOnce(int[] nums){
        int xorResult = 0;
        for (int num : nums){
            xorResult ^= num;
        }

        int indexOfMostRight1 = findIndexOfMostRight1(xorResult);
        int num1 = 0;
        int num2 = 0;
        for (int num : nums){
            if (isBit1(num, indexOfMostRight1)){
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }

        List<Integer> result = new ArrayList<>();
        result.add(num1);
        result.add(num2);
        return result;
    }

    private int findIndexOfMostRight1(int num){
        int count = 0;
        while ((num & 0x01) == 0){
            num >>= 1;
            count++;
        }

        return count;
    } 

    private boolean isBit1(int num, int indexBit){
        return ((num >> indexBit) & 0x01) == 1;
    }

    public static void main(String[] args){
        int[] nums = null;
        Solution sol = new Solution();
        
        // Case 1
        nums = new int[]{2, 4, 3, 6, 3, 2, 5, 5};
        System.out.println(Arrays.toString(nums));
        System.out.println(sol.findNumsAppearOnce(nums));
    }
}
