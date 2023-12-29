import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        int answer = 0, boxCount = 1;
        int i = 0;
        Stack<Integer> tempStack = new Stack<>();
        
        while (boxCount < order.length + 1) {
            if (order[i] == boxCount) {
                boxCount++;
                answer++;
                i++;
            }
            else if (!tempStack.isEmpty() && order[i] == tempStack.peek()) {
                tempStack.pop();
                answer++;
                i++;
            }
            else tempStack.push(boxCount++);
        }
        
        while (!tempStack.isEmpty() && order[i] == tempStack.pop()) {
            answer++;
            i++;
        }
        return answer;
    }
}