class Solution {
    public int solution(int n) {
        final int val = 1234567;
        int pre = 0;
        int post = 1;
        int answer = 0;
        
        for (int i = 0; i < n - 1; i++) {
            pre %= val;
            post %= val;
            answer = (pre + post) % val;
            pre = post;
            post = answer;
        }
        return answer;
    }
}