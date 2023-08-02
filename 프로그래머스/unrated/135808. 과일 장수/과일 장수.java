class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int count = 0;
        int[] kArr = new int[k + 1];
        final int resultCount = score.length - score.length % m;
        
        for (int i : score) kArr[i]++;

        for (int i = k; i > 0; i--) {
            if (count == resultCount) break;
            int remainder = kArr[i] % m;
            count += kArr[i] - remainder;
            kArr[i - 1] += remainder;
            answer += (kArr[i] - remainder) * i;
        }
        
        return answer;
    }
}