class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[] result = new int[] { triangle[0][0] };
        
        for (int i = 0; i < triangle.length - 1; i++) {
            int[] tempResult = new int[i + 2];
            
            for (int j = 0; j < triangle[i].length; j++) {
                int pre = result[j] + triangle[i + 1][j];
                int post = result[j] + triangle[i + 1][j + 1];
                
                tempResult[j] = Math.max(tempResult[j], pre);
                tempResult[j + 1] = Math.max(tempResult[j + 1], post);
                answer = Math.max(Math.max(pre, post), answer);
            }
            result = tempResult;
        }
        
        return answer;
    }
}