class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        for (int i = 0; i < t.length() - p.length() + 1; i++) {
            for (int j = 0; j < p.length(); j++) {
                if (Integer.valueOf(t.charAt(i + j)) == Integer.valueOf(p.charAt(j))) {
                    if (j == p.length() - 1) answer++;
                }
                else if (Integer.valueOf(t.charAt(i + j)) < Integer.valueOf(p.charAt(j))) {
                    answer++;
                    break;
                }
                else break;
            }
        }
        return answer;
    }
}