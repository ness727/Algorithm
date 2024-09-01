import java.util.PriorityQueue;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> result = new PriorityQueue<>((i, j) -> j - i);
        
        for (int work : works) result.add(work);
        while (n-- > 0) result.add(result.poll() - 1);
        for (int work : result) if (work > 0) answer += work * work;
        return answer;
    }
}