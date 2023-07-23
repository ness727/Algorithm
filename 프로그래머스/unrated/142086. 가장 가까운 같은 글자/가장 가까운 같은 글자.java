import java.util.HashMap;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        HashMap<Character, Integer> charMap = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (!charMap.containsKey(c)) {
                charMap.put(c, i);
                answer[i] = -1;
            }   
            else {
                answer[i] =  i - charMap.get(c);
                charMap.put(c, i);
            }
        }
        return answer;
    }
}