import java.util.Stack;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        Stack<Integer> dStack = new Stack<>();
        Stack<Integer> pStack = new Stack<>();
        
        int dZeroCount = 0, pZeroCount = 0;
        for (int i = 0; i < deliveries.length; i++) {
            if (deliveries[i] == 0) dZeroCount++;
            if (pickups[i] == 0) pZeroCount++;
            dStack.push(deliveries[i]);
            pStack.push(pickups[i]);
        }
        if (dZeroCount == dStack.size() && pZeroCount == pStack.size()) return 0;
        
        while (!(dStack.empty() && pStack.empty())) {
            answer += 2 * Math.max(dStack.size(), pStack.size());
            work(dStack, cap); // 배달
            work(pStack, cap); // 수거
        }
        return answer;
    }
    
    private void work(Stack<Integer> stack, int cap) {
        int tempCap = cap;
        
        while (!stack.empty()) {
            Integer i = stack.pop();
            tempCap -= i;
            if (tempCap <= 0)  {
                if (tempCap == 0) {
                   while (!stack.empty() && stack.peek() == 0) stack.pop(); 
                } else stack.push(-tempCap);
                break;
            }
        }
    }
}