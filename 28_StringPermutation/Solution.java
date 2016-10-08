import java.util.*;

public class Solution{
    public List<String> permutation(String s){
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0){
            return result;
        }

        helper(s.toCharArray(), result, 0);
        return result;
    }

    private void helper(char[] ss, List<String> result, int start){
        if (start == ss.length){
            result.add(String.valueOf(ss));
        } else {
            Set<Character> first = new HashSet<Character>();
            for (int i = start; i < ss.length; i++){
                if (!first.contains(ss[i])){
                    first.add(ss[i]);
                    swap(ss, start, i);
                    helper(ss, result, start + 1);
                    swap(ss, start, i);
                }
            }
        }
    }

    private void swap(char[] ss, int i, int j){
        char tmp = ss[i];
        ss[i] = ss[j];
        ss[j] = tmp;
    }

    public static void main(String[] args){
        String s = null;
        Solution sol = new Solution();
        List<String> result = null;

        // Case 1: null
        s = null;
        result = sol.permutation(s); 
        System.out.printf("Case %s\n", s);
        for (String str : result){
            System.out.println(str);
        }

        // Case 2: empty string
        s = "";
        result = sol.permutation(s); 
        System.out.printf("Case %s\n", s);
        for (String str : result){
            System.out.println(str);
        }

        // Case 3: string contains one character
        s = "a";
        result = sol.permutation(s); 
        System.out.printf("Case %s\n", s);
        for (String str : result){
            System.out.println(str);
        }
        
        // Case 4: string contains more than one characters
        s = "abc";
        result = sol.permutation(s); 
        System.out.printf("Case %s\n", s);
        for (String str : result){
            System.out.println(str);
        }

        // Case 5: string contains duplicated characters.
         s = "abacab";
         result = sol.permutation(s); 
         System.out.printf("Case %s\n", s);
         //for (String str : result){
         //    System.out.println(str);
         //}

         System.out.printf("Total: %d\n", result.size());
    }
}
