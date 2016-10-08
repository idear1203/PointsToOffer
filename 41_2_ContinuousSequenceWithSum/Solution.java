import java.util.*;

public class Solution{
    public List<List<Integer>> findContinuousSequence(int sum){
        List<List<Integer>> result = new ArrayList<>();
        if (sum < 3){
            return result;
        }

        int small = 1;
        int big = 2;
        int middle = (1 + sum) / 2;
        int curSum = small + big;
        while (small < middle){
            while (curSum > sum && small < middle){
                curSum -= small;
                small++;
            }

            if (curSum == sum){
                result.add(getSequence(small, big));
            }

            while (curSum <= sum && big < sum){
                big++;
                curSum += big;
            }
        }

        return result;
    }

    private List<Integer> getSequence(int small, int big){
        List<Integer> list = new ArrayList<>();
        for (int i = small; i <= big; i++){
            list.add(i);
        }

        return list;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int sum = 0;

        // Case 1
        sum = 9;
        System.out.println("sum = " + sum);
        System.out.println(sol.findContinuousSequence(sum));
        
        // Case 2
        sum = 15;
        System.out.println("sum = " + sum);
        System.out.println(sol.findContinuousSequence(sum));
        
        // Case 3
        sum = 100;
        System.out.println("sum = " + sum);
        System.out.println(sol.findContinuousSequence(sum));

        // Case 4
        sum = 4;
        System.out.println("sum = " + sum);
        System.out.println(sol.findContinuousSequence(sum));
    }
}
