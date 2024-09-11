class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        int val = s / n;
        
        if (s % n == s) return new int[] { -1 };
        for (int i = 0; i < n; i++) {
            answer[i] = val;
            s -= val;
            if (s % (val + 1) == 0 && (val + 1) * (n - i - 1) == s) val++;
        }
        return answer;
    }
}