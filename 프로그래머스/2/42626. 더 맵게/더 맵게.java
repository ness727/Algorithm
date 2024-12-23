import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> scovQ = new PriorityQueue<>();
        int answer = 0;
        
        for (int s : scoville) scovQ.add(s);
        
        while (scovQ.peek() < K && scovQ.size() > 1) {
            Integer last1 = scovQ.poll();
            Integer last2 = scovQ.poll();
            
            scovQ.add(last1 + last2 * 2);
            answer++;
        }
        return scovQ.peek() >= K ? answer : -1;
    }
}