import java.util.Stack;

class Solution {
    public int solution(String s) {
        Stack<Character> st = new Stack<>();      
        
        for (int i = 0; i < s.length(); i++) {
            if (!st.empty())
                if(st.peek() == s.charAt(i)) {
                    st.pop();
                    continue;
                }
            st.push(s.charAt(i));
        }
        
        return (st.empty()) ? 1 : 0;
    }
}