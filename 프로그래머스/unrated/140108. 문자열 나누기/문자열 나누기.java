class Solution {
    public int solution(String s) {
        int answer = 0;
        char c = ' ';
        int[] check = new int[] {0, 0};
        
        for (int i = 0; i < s.length(); i++) {
            if (check[0] == check[1]) {
                c = s.charAt(i);
                check[0] = 1;
                check[1] = 0;
                answer++;
            }
            else if (s.charAt(i) == c) check[0]++;
            else check[1]++;
        }
        return answer;
    }
}