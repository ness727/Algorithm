import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        int last = 0;
        
        Arrays.sort(targets, (t1, t2) -> { 
            if (t1[0] == t2[0]) return t1[1]-t2[1]; else return t1[0]-t2[0]; });
        
        last = targets[0][1];
        for (int i = 0; i < targets.length - 1; i++) {
            if (targets[i + 1][0] < last) {
                if (targets[i + 1][1] < last) last = targets[i + 1][1];
            }
            else {
                last = targets[i + 1][1];
                answer++;    
            }
        }
        if (targets[targets.length - 1][0] < last) answer++;
        
        return answer;
    }
}