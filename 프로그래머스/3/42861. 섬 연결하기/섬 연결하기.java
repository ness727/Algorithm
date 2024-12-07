import java.util.Arrays;

class Solution {
    int[] nodes;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        nodes = new int[n];
        
        for (int i = 0; i < n; i++) nodes[i] = i;
        
        Arrays.sort(costs, (arr1, arr2) -> Integer.compare(arr1[2], arr2[2]));
        
        for (int[] cost : costs) {
            int curIdx = cost[0];
            int nextIdx = cost[1];
            int val = cost[2];
            
            if (findRoot(curIdx) != findRoot(nextIdx)) {
                union(curIdx, nextIdx);
                answer += val;
            }
        }
        return answer;
    }
    
    private int findRoot(int idx) {
        if (idx != nodes[idx]) return findRoot(nodes[idx]);
        else return idx;
    }
    
    private void union(int idx1, int idx2) {
        int root1 = findRoot(idx1);
        int root2 = findRoot(idx2);
        
        nodes[root2] = root1;
    }
}