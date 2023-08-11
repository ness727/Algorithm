class Solution {
    public int solution(int n) {
        int answer = n;
        
        while (true) {
            answer++;
            if (Integer.bitCount(n) == Integer.bitCount(answer)) return answer;
        }
    }
}