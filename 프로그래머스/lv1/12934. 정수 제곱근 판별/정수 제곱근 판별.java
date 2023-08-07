class Solution {
    public long solution(long n) {
        double temp = Math.sqrt(n);
        return (temp - Math.floor(temp) < 1e-14) ? (long) Math.pow(temp + 1, 2) : -1;
    }
}