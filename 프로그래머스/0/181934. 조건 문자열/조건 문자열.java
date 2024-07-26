class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        if (ineq.equals("<")) { if (n > m) return 0; }
        else { if (n < m) return 0; }
        if (eq.equals("!")) { if (n == m) return 0; }
        return 1;
    }
}