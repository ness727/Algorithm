import java.util.Queue;
import java.util.LinkedList;
import java.util.HashSet;

class Solution {
    public int solution(int x, int y, int n) {
        if (x == y) return 0;
        int answer = 1;
        Queue<Integer> result = new LinkedList<>();
        HashSet<Integer> visitedSet = new HashSet<>();
        
        result.add(x);
        while (result.size() > 0) {
            int count = result.size();
            
            for (int i = 0; i < count; i++) {
                int num = result.poll();
                int[] temp = new int[] { num + n, num * 2, num * 3 };
                
                for (int j = 0; j < 3; j++)
                    if (temp[j] < y && !visitedSet.contains(temp[j])) {
                        result.add(temp[j]);
                        visitedSet.add(temp[j]);
                    }

                if (temp[0] == y || temp[1] == y || temp[2] == y)
                    return answer;
            }
            answer++;
        }
        return result.isEmpty() ? -1 : answer;
    }      
}