class Solution {
    public String solution(int n) {
        return new StringBuilder().append("수박".repeat(n/2)).toString() + ((n % 2 != 0) ? "수" : "");
    }
}