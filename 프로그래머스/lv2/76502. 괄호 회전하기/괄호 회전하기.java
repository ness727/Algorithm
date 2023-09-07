import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Stack<Character> result = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            result.clear();
            sb.setLength(0);
            sb.append(s.substring(i, s.length())).append(s.substring(0, i));
            String check = sb.toString();
            
            for (int j = 0; j < check.length(); j++) {
                char c = check.charAt(j);
                
                if (c == '[' || c == '{' || c == '(') {
                    result.push(c);
                }
                else {
                    if (result.isEmpty()) break;
                    else {
                        if (c == ']') {
                            if (result.peek() != '[') break;
                            else result.pop();
                        }
                        else if (c == '}') {
                            if (result.peek() != '{') break;
                            else result.pop();
                        }
                        else {
                            if (result.peek() != '(') break;
                            else result.pop();
                        }
                    }
                }
                
                if (j == check.length() - 1 && result.size() == 0) answer++;
            }
        }
        return answer;
    }
}