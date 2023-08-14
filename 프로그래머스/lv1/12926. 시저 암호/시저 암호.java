class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == ' ')
                answer.append(" ");
            else {
                if(c + n > 90 && c <= 90)
                    answer.append(String.valueOf((char)((c + n) % 90 + 64)));
                else {
                    if (c + n > 122 && c >= 97)
                        answer.append(String.valueOf((char)((c + n) % 122 + 96)));
                    else answer.append(String.valueOf((char)(c + n)));
                }
            }
        }
        
        return answer.toString();
    }
}