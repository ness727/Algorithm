import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> preEnemyQueue 
            = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        
        for (int i = 0; i < enemy.length; i++) {
            if (enemy[i] <= n) {
                preEnemyQueue.add(enemy[i]);
                n -= enemy[i];
            } else {
                if (0 < k) {
                    if (!preEnemyQueue.isEmpty() 
                        && enemy[i] <= preEnemyQueue.peek()) {
                        n += (preEnemyQueue.poll() - enemy[i]);
                        preEnemyQueue.add(enemy[i]);
                    }
                    k--;
                } else break;
            }
            answer++;
        }
        return answer;
    }
}