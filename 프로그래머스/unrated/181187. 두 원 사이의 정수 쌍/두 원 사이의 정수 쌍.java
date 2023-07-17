class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        final long R1_POW = (long) r1 * r1;
        final long R2_POW = (long) r2 * r2;

        for (long x = 1; x < r2; x++) {
            if (x < r1) {
                long r1Y = (long) Math.floor(Math.sqrt(R1_POW - x * x));
                long r2Y = (long) Math.floor(Math.sqrt(R2_POW - x * x));
                answer += r2Y - r1Y;
                if (r1Y * r1Y + x * x == R1_POW) answer++;
            }
            else answer += (long) Math.floor(Math.sqrt(R2_POW - x * x));
        }
        return (answer + (r2 - r1 + 1)) * 4;
    }
}