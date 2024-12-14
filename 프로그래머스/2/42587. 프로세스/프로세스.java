import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> numQueue = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int priority : priorities) numQueue.add(priority);
        
        for (int i = 0; i < priorities.length; i++) {
            for (int j = 0; j < priorities.length; j++) {
                if (priorities[j] == 0) continue;
                
                if (priorities[j] == numQueue.peek()) {
                    if (j == location) return ++answer;
                    else {
                        numQueue.poll();
                        priorities[j] = 0;
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}