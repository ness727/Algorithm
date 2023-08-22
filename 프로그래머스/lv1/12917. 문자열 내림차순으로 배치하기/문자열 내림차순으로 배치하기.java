import java.util.Arrays;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int[] intCharArr = new int[s.length()];
        
        for (int i = 0; i < s.length(); i++) intCharArr[i] = -s.charAt(i);
        Arrays.sort(intCharArr);
        for (int i : intCharArr) answer.append(Character.toString((char)-i));
        
        return answer.toString();
    }
}