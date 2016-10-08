import java.util.*;

public class Solution{
    public int getNumberOfK(int[] nums, int k){
        if (nums == null || nums.length == 0){
            return 0;
        }

        int first = getFirst(nums, k);
        int last = getLast(nums, k);
        if (first > 0 && last > 0){
            return last - first + 1;
        }

        return 0;
    }

    private int getFirst(int[] nums, int k){
        int s = 0;
        int e = nums.length;
        while (s < e){
            int m = s + (e - s) / 2;
            if (nums[m] < k){
                s = m + 1;
            } else {
                e = m;
            }
        }

        if (s < nums.length && nums[s] == k){
            return s;
        }

        return -1;
    }

    private int getLast(int[] nums, int k){
        int s = 0;
        int e = nums.length;
        while (s < e){
            int m = s + (e - s) / 2;
            if (nums[m] <= k){
                s = m + 1;
            } else {
                e = m;
            }
        }

        if (s - 1 >= 0 && nums[s - 1] == k){
            return s - 1;
        }

        return -1;
    }

    public static void main(String[] args){
        int[] nums = null;
        int k = 0;
        Solution sol = new Solution();

        // Case 1
        nums = new int[] {1, 2, 3, 3, 3, 3, 4, 5};
        k = 4;
        System.out.println(Arrays.toString(nums));
        System.out.println("k = " + k);
        System.out.println(sol.getNumberOfK(nums, k));

        // Case 2
        nums = new int[] {1, 2, 3, 3, 3, 3, 4, 5};
        k = 3;
        System.out.println(Arrays.toString(nums));
        System.out.println("k = " + k);
        System.out.println(sol.getNumberOfK(nums, k));

        // Case 3
        nums = new int[] {1, 2, 3, 3, 3, 3, 4, 5};
        k = 0;
        System.out.println(Arrays.toString(nums));
        System.out.println("k = " + k);
        System.out.println(sol.getNumberOfK(nums, k));
    }
}
