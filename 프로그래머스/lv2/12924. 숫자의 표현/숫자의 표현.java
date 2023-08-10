class Solution {
    public int solution(int n) {
        int answer = 0;
        int preNum = 1;
        int sum = 0;
        int count = 0;
        
        for (int i = 1; i <= n; i++) {
            sum += i;
            if (sum > n) 
                while(sum > n) sum -= preNum++;
            if (sum == n) {
                count = i - preNum + 1;
                answer++;
                break;
            }
        }
        
        for (int i = 2; i < count; i++) {
            sum = 0;
            
            for (int j = 1; j < i; j++) sum += j;
            while (sum < n) sum += i;
            if (sum == n) answer++;
        }
        return (count == 1) ? answer : ++answer;
    }
}