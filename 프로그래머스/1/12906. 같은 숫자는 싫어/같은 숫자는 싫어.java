import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        List<Integer> answer = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        
        for (int i = arr.length - 1; i >= 0; i--) {
            stack.push(arr[i]);
        }
        
        while (!stack.isEmpty()) {
            int num = stack.pop();
            while (!stack.isEmpty() && stack.peek() == num) stack.pop();
            answer.add(num);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}