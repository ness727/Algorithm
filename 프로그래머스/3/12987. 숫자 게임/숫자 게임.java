import java.util.PriorityQueue;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        PriorityQueue<Integer> aQueue = new PriorityQueue<>((i, j) -> j - i);
        PriorityQueue<Integer> bQueue = new PriorityQueue<>((i, j) -> j - i);
        
        for (int a : A) aQueue.add(a);
        for (int b : B) bQueue.add(b);
        
        while (aQueue.size() > 0) {
            int a = aQueue.poll();
            int b = bQueue.peek();
            
            if (b > a) {
                answer++;
                bQueue.poll();
            }
        }
        return answer;
    }
}