public class Solution{
    public int numberOf1Between1AndN(int n){
        if (n <= 0){
            return 0;
        }

        return helper(String.valueOf(n));
    }

    private int helper(String s){
        if (s.length() == 1){
            if (s.charAt(0) == '0'){
                return 0;
            } else {
                return 1;
            }
        } else {
            int len = s.length();
            int first = s.charAt(0) - '0';
            // 记录最高位为1的总数
            int numberOfFirstDigit = 0;
            if (first > 1){
                // Case 21345
                numberOfFirstDigit = (int)Math.pow(10, len - 1);
            } else {
                // Case 12345
                numberOfFirstDigit = Integer.parseInt(s.substring(1)) + 1;
            }

            // 1出现在非最高位上。剩余位共有len - 1位，设定其中一位为1，其余位可以随便填。
            int numberOfOtherDigits = (len - 1) * first *  (int)Math.pow(10, len - 2);

            // 可以看做是最高位为0的情况
            int numberOfRecursive = helper(s.substring(1));

            return numberOfFirstDigit + numberOfOtherDigits + numberOfRecursive;
        }
    }

    public static void main(String[] args){
        int n = 0;
        Solution sol = new Solution();

        // Case 1
        n = 0;
        System.out.println(n);
        System.out.println(sol.numberOf1Between1AndN(n));

        // Case 2
        n = 1;
        System.out.println(n);
        System.out.println(sol.numberOf1Between1AndN(n));

        // Case 3
        n = 5;
        System.out.println(n);
        System.out.println(sol.numberOf1Between1AndN(n));

        // Case 4
        n = 12;
        System.out.println(n);
        System.out.println(sol.numberOf1Between1AndN(n));

        // Case 5
        n = 21315;
        System.out.println(n);
        System.out.println(sol.numberOf1Between1AndN(n));
    }
}
