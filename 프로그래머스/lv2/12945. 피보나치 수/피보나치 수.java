class Solution {
    public int solution(int n) {
        final int VAL = 1234567;
        int pre = 0;
        int post = 1;
        int answer = 0;
        
        for (int i = 0; i < n - 1; i++) {
            pre %= VAL;
            post %= VAL;
            answer = (pre + post) % VAL;
            pre = post;
            post = answer;
        }
        return answer;
    }
}