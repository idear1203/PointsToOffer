public class Solution{
    public int findGreatestSumOfSubArray(int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums){
            sum += num;
            max = Math.max(sum, max);
            sum = Math.max(sum, 0);
        }

        return max;
    }

    public static void main(String[] args){
        int[] nums = {1, -2, 3, 10, -4, 7, 2, -5};
        Solution sol = new Solution();
        System.out.println(sol.findGreatestSumOfSubArray(nums));
    }
}
