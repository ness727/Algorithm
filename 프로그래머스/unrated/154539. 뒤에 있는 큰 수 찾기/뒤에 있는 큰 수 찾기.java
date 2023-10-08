import java.util.Stack;

class Solution {
    public int[] solution(int[] numbers) {
        Stack<Integer> savedIndexes = new Stack<>();
        
        for (int i = 0; i < numbers.length; i++) {
            if (savedIndexes.isEmpty() || numbers[savedIndexes.peek()] >= numbers[i]) {
                savedIndexes.push(i);
                continue;
            }
            while(!savedIndexes.isEmpty() && numbers[savedIndexes.peek()] < numbers[i]) {
                numbers[savedIndexes.pop()] = numbers[i];
            }
            savedIndexes.push(i);
        }
        
        while (!savedIndexes.isEmpty()) {
            numbers[savedIndexes.pop()] = -1;
        }
        
        return numbers;
    }
}