class Solution {
    public int solution(int n) {
        int answer = 1;
        
        for (int i = 3; i < n + 1; i++)
            answer += isPrime(i);
        return answer;
    }
    
    public int isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++)
            if (num % i == 0) return 0;
        return 1;
    }
}