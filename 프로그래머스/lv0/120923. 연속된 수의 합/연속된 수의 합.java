import java.util.stream.IntStream;

class Solution {
    public int[] solution(int num, int total) {
        int[] answer = IntStream.rangeClosed(1, num).toArray();
        int sum = 0;
        
        for (int i : answer) sum += i;
        
        int countSum = 0;
        int count = (sum > total) ? -1 : 1;
        while(true) {
            if (sum == total) {
                for (int j = 0; j < answer.length; j++) answer[j] += countSum;
                return answer;
            }
            sum += (sum < total ? num : -num);
            countSum += count;
        }
    }
}