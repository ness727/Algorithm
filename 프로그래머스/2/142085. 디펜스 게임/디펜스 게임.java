import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> enemyQueue 
            = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        
        for (int i = 0; i < enemy.length; i++) {
            if (enemy[i] <= n) {
                enemyQueue.add(enemy[i]);
                n -= enemy[i];
            } else {
                if (0 < k) {
                    if (!enemyQueue.isEmpty() 
                        && enemy[i] <= enemyQueue.peek()) {
                        n += (enemyQueue.poll() - enemy[i]);
                        enemyQueue.add(enemy[i]);
                    }
                    k--;
                } else break;
            }
            answer++;
        }
        return answer;
    }
}