import java.util.*;

public class Solution{
    public boolean isPopOrder(int[] pushOrder, int[] popOrder){
        if (pushOrder.length != popOrder.length){
            return false;
        }

        int n = pushOrder.length;
        int pushIdx = 0;
        int popIdx = 0;
        Stack<Integer> stack = new Stack<>();
outer:
        while (popIdx < n && pushIdx < n){
            // Make sure peek element of stack equals to element to be poped.
            while (stack.isEmpty() || stack.peek() != popOrder[popIdx]){
                if (pushIdx == n){
                    break outer;
                }

                stack.push(pushOrder[pushIdx++]);
            }

            stack.pop();
            popIdx++;
        }

        return stack.isEmpty() && popIdx == n;
    }
}
