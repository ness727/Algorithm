import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> result = new LinkedList<>();
        int answer = 0;
        int max = 9;
        
        for (int i : priorities) result.add(i);
        
        while(result.size() != 0) {
            while (max != 0) {
                if (!result.contains(max)) max--;
                else break;
            }
            if (result.peek() == max) {
                result.poll();
                answer++;
                if (location == 0) return answer;
                else location--;
            }
            else {
                result.add(result.poll());
                if (location == 0) location = result.size() - 1;
                else location--;
            }
        }
        return answer;
    }
}