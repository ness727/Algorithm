import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        int nodeSize = computers.length;
        ArrayList<Integer>[] nodes = new ArrayList[computers.length];
        boolean[] visited = new boolean[nodeSize];
        
        for (int i = 0; i < nodeSize; i++) {
            nodes[i] = new ArrayList<>();
            
            for (int j = 0; j < nodeSize; j++)  {
                if (i == j) continue;
                if (computers[i][j] == 1) nodes[i].add(j);
            }
        }
        
        for (int i = 0; i < nodeSize; i++) {            
            if (visited[i]) continue;
            else {
                Queue<Integer> nodeQ = new LinkedList<>();
                nodeQ.add(i);
                visited[i] = true;
                
                while (!nodeQ.isEmpty()) {
                    Integer node = nodeQ.poll();
                    
                    for (Integer linkedNode : nodes[node]) {
                        if (!visited[linkedNode]) {
                            nodeQ.add(linkedNode);
                            visited[linkedNode] = true;
                        }
                    }
                }
            }
            answer++;
        }
        return answer;
    }
}