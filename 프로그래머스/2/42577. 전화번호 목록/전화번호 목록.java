import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        
        String prev = "-";
        for (String s : phone_book) {
            if (s.startsWith(prev)) return false;
            else prev = s;
        }
        return true;
    }
}