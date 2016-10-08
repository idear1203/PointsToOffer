import java.util.*;

public class Solution{
    public List<List<Integer>> findNumbersWithSum(int[] nums, int sum){
        if (nums == null || nums.length == 0){
            return Collections.emptyList();
        }

        List<List<Integer>> result = new ArrayList<>();
        int ahead = nums.length - 1;
        int behind = 0;
        while (ahead > behind){
            if (nums[ahead] + nums[behind] == sum){
                result.add(Arrays.asList(nums[behind], nums[ahead]));
                ahead--;
                behind++;
            } else if (nums[ahead] + nums[behind] < sum){
                behind++;
            } else {
                ahead--;
            }
        }

        return result;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[] nums = null;
        int sum = 0;

        // Case 1
        nums = new int[]{1, 2, 4, 7, 11, 15};
        sum = 15;
        System.out.println(Arrays.toString(nums));
        System.out.println("sum = " + sum);
        System.out.println(sol.findNumbersWithSum(nums, sum));
    }
}
