import java.util.*;

public class Solution{
    public String leftRotateString(String s, int n){
        if (s == null || s.isEmpty() || n <= 0){
            return s;
        }

        char[] ss = s.toCharArray();
        int len = ss.length;
        n = n % len;

        // Reverse the whole string
        reverse(ss, 0, len - 1);
        // Reverse the former part
        reverse(ss, 0, len - n - 1);
        // Reverse the latter part
        reverse(ss, len - n, len - 1);

        return String.valueOf(ss);
    }

    private void reverse(char[] s, int start, int end){
        while (start < end){
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String args[]){
        Solution sol = new Solution();
        String s = null;
        int n = 0;

        // Case 1
        s = "abcdefg";
        n = 2;
        System.out.println("s = " + s);
        System.out.println("n = " + n);
        System.out.println(sol.leftRotateString(s, n));
    }
}
