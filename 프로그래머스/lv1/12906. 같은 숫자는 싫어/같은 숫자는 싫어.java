import java.util.Stack;

public class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        
        stack.push(arr[0]);
        for (int i = 0; i < arr.length; i++)
            if (stack.peek() != arr[i]) stack.push(arr[i]);
        return stack.stream().mapToInt(i -> i).toArray();
    }
}