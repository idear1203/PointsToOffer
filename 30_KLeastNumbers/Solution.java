import java.util.*;

public class Solution{

    public List<Integer> getLeastNumbers(int[] nums, int k){
        //return partitionBasedGetLeastNumbers(nums, k);
        return heapBasedGetLeastNumbers(nums, k);
    }

    /**
     * The implementation based on partition.
     */
    public List<Integer> partitionBasedGetLeastNumbers(int[] nums, int k){
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length){
            return result;
        }

        int start = 0;
        int end = nums.length - 1;
        int index = partition(nums, start, end);
        k--;
        while (index != k){
            if (index > k){
                index = partition(nums, start, index - 1);
            } else {
                index = partition(nums, index + 1, end);
            }
        }

        for (int i = 0; i <= k; i++){
            result.add(nums[i]);
        }

        return result;
    }

    private int partition(int[] nums, int start, int end){
        int pivot = nums[start];
        while (start < end){
            while (start < end && nums[end] >= pivot){
                end--;
            }

            nums[start] = nums[end];
            while (start < end && nums[start] <= pivot){
                start++;
            }

            nums[end] = nums[start];
        }

        nums[start] = pivot;
        return start;
    }

    public List<Integer> heapBasedGetLeastNumbers(int[] nums, int k){
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length){
            return result;
        }

        // Build max heap in size of `k`.
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int i = 0; i < k; i++){
            queue.offer(nums[i]);
        }

        for (int i = k; i < nums.length; i++){
            if (nums[i] < queue.peek()){
                queue.poll();
                queue.offer(nums[i]);
            }
        }

        while (!queue.isEmpty()){
            result.add(queue.poll());
        }

        return result;
    }

    public static void main(String[] args){
        int[] nums = null;
        int k = 0;
        Solution sol = new Solution();

        // Case 1: normal case
        nums = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        k = 4;
        System.out.println(Arrays.toString(nums));
        System.out.println(String.format("k: %d", k));
        System.out.println(sol.getLeastNumbers(nums, k));

        // Case 2: k = 1
        nums = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        k = 1;
        System.out.println(Arrays.toString(nums));
        System.out.println(String.format("k: %d", k));
        System.out.println(sol.getLeastNumbers(nums, k));
        
        // Case 3: `k` equals to length of `nums`
        nums = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        k = nums.length;
        System.out.println(Arrays.toString(nums));
        System.out.println(String.format("k: %d", k));
        System.out.println(sol.getLeastNumbers(nums, k));
        
        // Case 4: `k` is larger than length of `nums`
        nums = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        k = nums.length + 10;
        System.out.println(Arrays.toString(nums));
        System.out.println(String.format("k: %d", k));
        System.out.println(sol.getLeastNumbers(nums, k));
    }
}
