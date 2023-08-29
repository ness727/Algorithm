class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int nextIndex = 1;
        int count = 0;
        int row = 0, col = -1;
        
        while (true) {
            for (int j = 0; j < n; j++) {
                count++;
                col += nextIndex;
                answer[row][col] = count;
            }
            
            if (count == answer.length * answer.length) break;
            n--;
            
            for (int j = 0; j < n; j++) {
                count++;
                row += nextIndex;
                answer[row][col] = count;
            }
            nextIndex *= -1;
        }
        
        
        return answer;
    }
}