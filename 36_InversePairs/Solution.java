import java.util.*;

public class Solution{
    public int inversePairs(int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        }

        int count = helper(nums, 0, nums.length - 1);
        return count;
    }

    private int helper(int[] nums, int start, int end){
        if (start == end){
            return 0;
        }

        int mid = start + (end - start) / 2;
        int leftCount = helper(nums, start, mid);
        int rightCount = helper(nums, mid + 1, end);
        int count = 0;
        int[] copy = new int[end - start + 1];
        int index = end - start;
        int i = mid, j = end;
        while (i >= start && j >= mid + 1){
            if (nums[i] > nums[j]){
                copy[index--] = nums[i--];
                count += j - mid;
            } else {
                copy[index--] = nums[j--];
            }
        }

        while (i >= start){
            copy[index--] = nums[i--];
        }

        while(j >= mid + 1){
            copy[index--] = nums[j--];
        }

        for (i = start; i <= end; i++){
            nums[i] = copy[i - start];
        }

        return leftCount + rightCount + count;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[] nums = null;

        // Case 1
        nums = new int[]{7, 5, 6, 4};
        System.out.println(Arrays.toString(nums));
        System.out.println(sol.inversePairs(nums));

        // Case 2
        nums = new int[]{7, 6, 5, 4};
        System.out.println(Arrays.toString(nums));
        System.out.println(sol.inversePairs(nums));

        // Case 3
        nums = new int[]{4, 5, 6, 7};
        System.out.println(Arrays.toString(nums));
        System.out.println(sol.inversePairs(nums));
        
        // Case 4
        nums = new int[]{4, 5, 5, 7};
        System.out.println(Arrays.toString(nums));
        System.out.println(sol.inversePairs(nums));
    }
}
