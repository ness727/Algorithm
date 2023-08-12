class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int remainder = 0;
        
        while(true) {
            if (n < a) break;
            remainder += n % a;
            answer += n / a * b;
            n = remainder + n / a * b;
            remainder = 0;
        }
        return answer;
    }
}