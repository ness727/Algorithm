import java.util.Arrays;

class Solution {
    public int solution(String[] spell, String[] dic) {
        return Arrays.stream(dic)
            .map(s -> {
                for (String sp : spell)
                    s = (s.contains(sp) ? s.replaceFirst(sp, "") : "1"); 
                return s;
            })
            .anyMatch(s -> s.equals("")) ? 1 : 2;
    }
}