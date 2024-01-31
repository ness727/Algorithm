import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long q1Sum = 0, q2Sum = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        for (int i : queue1) {
            q1Sum += i;
            q1.add(i);
        }
        for (int i : queue2) {
            q2Sum += i;
            q2.add(i);
        }
        
        for (int i = 0; i < queue1.length * 3;) {
            if (q1Sum > q2Sum) {  // q1Sum 이 q2Sum 보다 크면 q1 에서 추출
                Integer temp = q1.poll();
                q2.add(temp);
                q1Sum -= temp;
                q2Sum += temp;
            } else if (q1Sum < q2Sum) {  // q2Sum 이 q1Sum 보다 크면 q2 에서 추출
                Integer temp = q2.poll();
                q1.add(temp);
                q2Sum -= temp;
                q1Sum += temp;
            } else {  // q1Sum 과 q2Sum 이 같은 경우
                return answer;
            }
            answer++;
            i++;
        }
        return -1;
    }
}