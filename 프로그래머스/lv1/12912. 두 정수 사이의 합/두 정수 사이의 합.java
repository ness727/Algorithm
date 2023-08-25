class Solution {
    public long solution(int a, int b) {
        long min = Math.min(a, b);
        long max = Math.max(a, b);
        
        return (long)((max + 1) * max / 2 - (min + 1) * min / 2) + min;
    }
}