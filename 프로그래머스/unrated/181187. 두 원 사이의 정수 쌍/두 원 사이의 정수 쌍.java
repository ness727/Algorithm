class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        final long r1_pow = (long) r1 * r1;
        final long r2_pow = (long) r2 * r2;

        for (long x = 1; x < r2; x++) {
            if (x < r1) {
                long r1Y = (long) Math.floor(Math.sqrt(r1_pow - x * x));
                long r2Y = (long) Math.floor(Math.sqrt(r2_pow - x * x));
                answer += r2Y - r1Y;
                if (r1Y * r1Y + x * x == r1_pow) answer++;
            }
            else answer += (long) Math.floor(Math.sqrt(r2_pow - x * x));
        }
        return (answer + (r2 - r1 + 1)) * 4;
    }
}