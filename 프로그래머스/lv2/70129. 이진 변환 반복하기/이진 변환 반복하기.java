import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        Pattern pattern = Pattern.compile("0");
        Matcher matcher;
        
        while(!s.equals("1")) {
            matcher = pattern.matcher(s);
            while (matcher.find()) {
                matcher.group();
                answer[1]++;
            }
            s = Integer.toBinaryString(s.replaceAll("0", "").length());
            answer[0]++;
        }
        
        return answer;
    }
}