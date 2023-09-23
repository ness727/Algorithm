class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer;
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i <= t * m; i++)
            result.append(Integer.toString(i, n));
        
        answer = result.toString();
        result.setLength(0);
        
        for (int i = p - 1, count = 0; ; i += m, count++) {
            if (count < t) result.append(answer.substring(i, i + 1));
            else break;
        }
        return result.toString().toUpperCase();
    }
}