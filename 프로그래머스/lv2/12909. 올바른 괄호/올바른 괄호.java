import java.util.Stack;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        char[] c = s.toCharArray();
        
        if (c[0] == ')') return false;
        for (int i = 0; i < s.length(); i++) {
            if (c[i] == ')' && !stack.empty() && stack.peek() == '(') stack.pop();
            else stack.push(c[i]);
        }
        return stack.size() == 0 ? true : false;
    }
}