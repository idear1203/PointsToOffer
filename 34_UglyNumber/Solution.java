public class Solution{
    public int getUglyNumber(int n){
        if (n <= 0){
            return 0;
        }

        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        int index = 0;
        while (index < n - 1){
            int min = Math.min(uglyNumbers[index2] * 2, Math.min(uglyNumbers[index3] * 3, uglyNumbers[index5] * 5));
            
            // Must put to array first in order to make sure conditions at below can take effect at least for the last element.
            uglyNumbers[++index] = min;

            while (uglyNumbers[index2] * 2 <= min){
                index2++;
            }

            while (uglyNumbers[index3] * 3 <= min){
                index3++;
            }

            while (uglyNumbers[index5] * 5 <= min){
                index5++;
            }
        }

        return uglyNumbers[n - 1];
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int n = 0;
        
        // Case 1-20
        for (int i = 0; i < 20; i++){
            System.out.printf("%d %d\n", i, sol.getUglyNumber(i));
        }

        // Case 21
        n = 1500;
        System.out.printf("%d %d\n", n, sol.getUglyNumber(n));
    }
}
