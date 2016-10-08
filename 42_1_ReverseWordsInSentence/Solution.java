import java.util.*;

public class Solution{
    public String reverseSentence(String s){
        if (s == null || s.isEmpty()){
            return s;
        }

        char[] ss = s.toCharArray();
        int start = 0;
        int end = ss.length - 1;
        
        // Reverse the whole string
        reverse(ss, start, end);

        // Reverse every word in the sentence.
        start = end = 0;
        while (start < ss.length){
            if (ss[start] == ' '){
                start++;
                end++;
            } else if (end == ss.length || ss[end] == ' '){
                reverse(ss, start, end - 1);
                start = end;
            } else {
                end++;
            }
        }

        return String.valueOf(ss);
    }

    private void reverse(char[] s, int start, int end){
        if (start < end){
            swap(s, start, end);
            reverse(s, start + 1, end - 1);
        }
    }

    void swap(char[] s, int start, int end){
        char tmp = s[start];
        s[start] = s[end];
        s[end] = tmp;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        String s = null;

        // Case 1
        s = null;
        System.out.println(s);
        System.out.println(sol.reverseSentence(s));
        
        // Case 2
        s = "word";
        System.out.println(s);
        System.out.println(sol.reverseSentence(s));
        
        // Case 3
        s = "I am a student.";
        System.out.println(s);
        System.out.println(sol.reverseSentence(s));
        
        // Case 4
        s = "I   am a student.";
        System.out.println(s);
        System.out.println(sol.reverseSentence(s));
    }
}
