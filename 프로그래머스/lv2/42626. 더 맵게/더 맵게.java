import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> result = new PriorityQueue<>();
        int answer = 0;
        
        for (int i : scoville) result.add(i);
        
        while(result.peek() < K && result.size() != 1) {
            result.add(result.poll() + result.poll() * 2);
            answer++;
        }
        return result.peek() < K ? -1 : answer;
    }
}