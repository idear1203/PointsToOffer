import java.util.*;

public class Solution{
    public String printMinNumber(int[] nums){
        List<String> strNumbers = new ArrayList<>();
        for (int num : nums){
            strNumbers.add(String.valueOf(num));
        }

        Collections.sort(strNumbers, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return (s1 + s2).compareTo(s2 + s1);
            }
        });

        return String.join("", strNumbers);
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[] nums = null;

        // Case 1: array contains many elements.
        nums = new int[]{3, 32, 321};
        System.out.println(Arrays.toString(nums));
        System.out.println(sol.printMinNumber(nums));

        // Case 2
        nums = new int[]{ 321};
        System.out.println(Arrays.toString(nums));
        System.out.println(sol.printMinNumber(nums));
    }
}
