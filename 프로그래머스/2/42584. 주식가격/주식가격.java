import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> result = new Stack<>();
        int[] answer = new int[prices.length];
        
        answer[0] = prices.length - 1;
        result.push(0);
        for (int i = 1; i < prices.length; i++) {
            while (!result.isEmpty() && prices[result.peek()] > prices[i]) {
                int pre = result.pop();
                answer[pre] = i - pre;
            }
            answer[i] = prices.length - (i + 1);
            result.push(i);
        }
        return answer;
    }
}