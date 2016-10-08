import java.util.*;

public class Solution{
    public char firstNotRepeatingChar(String s){
        if (s == null || s.isEmpty()){
            return '\0';
        }

        int[] visit = new int[256];
        for (int i = 0; i < s.length(); i++){
            visit[s.charAt(i)]++;
        }

        for (int i = 0; i < s.length(); i++){
            if (visit[s.charAt(i)] == 1){
                return s.charAt(i);
            }
        }

        return '\0';
    }

    public static void main(String[] args){
        String s = null;
        Solution sol = new Solution();

        // Case 1: null
        s = null;
        System.out.println(s);
        System.out.println(String.valueOf(sol.firstNotRepeatingChar(s)));
        
        // Case 2: empty string
        s = "";
        System.out.println(s);
        System.out.println(String.valueOf(sol.firstNotRepeatingChar(s)));

        // Case 3: every character appears only once.
        s = "abc";
        System.out.println(s);
        System.out.println(String.valueOf(sol.firstNotRepeatingChar(s)));
        
        // Case 4: every character appears more than once.
        s = "abccba";
        System.out.println(s);
        System.out.println(String.valueOf(sol.firstNotRepeatingChar(s)));
        
        // Case 5: some characters appear once.
        s = "abaccdeff";
        System.out.println(s);
        System.out.println(String.valueOf(sol.firstNotRepeatingChar(s)));
    }
}
