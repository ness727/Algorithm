import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] routes) {
        PriorityQueue<int[]> sortedRoutes 
            = new PriorityQueue<>((arr1, arr2) -> arr1[1] - arr2[1]);
        int answer = 0;
        
        for (int[] route : routes) sortedRoutes.add(route);
        
        while (sortedRoutes.size() > 0) {
            int[] cur = sortedRoutes.poll();
            
            while (sortedRoutes.size() > 0 && sortedRoutes.peek()[0] <= cur[1]) {
                sortedRoutes.poll();
            }
            answer++;
        }
        return answer;
    }
}