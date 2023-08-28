class Solution {
    public String solution(int a, int b) {
        String[] answer = new String[] { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
        int result = 4;
        int[] month = new int[] { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30 };
        
        for (int i = 0; i < a - 1; i++) result += month[i];
        result += b;
        result %= 7;
        return answer[result];
    }
}