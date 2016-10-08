import java.util.*;

public class Solution{
    Stack<Integer> dataStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int x){
        dataStack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()){
            minStack.push(x);
        }
    }

    public int peek(){
        return dataStack.peek();
    }

    public int pop(){
        int x = dataStack.pop();
        if (x == minStack.peek()){
            minStack.pop();
        }

        return x;
    }

    public int getMin(){
        return minStack.peek();
    }
}
