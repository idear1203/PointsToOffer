import java.util.*;

public class Solution{
    public int moreThanHalfNum(int[] nums){
        if (nums == null || nums.length == 0){
            return -1;
        }

        int candidate = 0;
        int vote = 0;
        for (int num : nums){
            if (vote == 0){
                candidate = num;
            }

            if (num == candidate){
                vote++;
            } else {
                vote--;
            }
        }

        int count = 0;
        for (int num : nums){
            if (num == candidate){
                count++;
            }
        }

        return count > nums.length / 2 ? candidate : -1;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[] nums = null;

        // Case 1: null
        nums = null;
        System.out.println(Arrays.toString(nums));
        System.out.println(sol.moreThanHalfNum(nums));

        // Case 2: empty array
        nums = new int[0];
        System.out.println(Arrays.toString(nums));
        System.out.println(sol.moreThanHalfNum(nums));

        // Case 3: array contains only one element
        nums = new int[]{1};
        System.out.println(Arrays.toString(nums));
        System.out.println(sol.moreThanHalfNum(nums));

        // Case 4: 2 appears more than half times
        nums = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(Arrays.toString(nums));
        System.out.println(sol.moreThanHalfNum(nums));
        
        // Case 5: no element appear more than half times
        nums = new int[]{1, 2, 3, 2, 2, 4, 5};
        System.out.println(Arrays.toString(nums));
        System.out.println(sol.moreThanHalfNum(nums));
    }
}
