import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        Pattern pattern = Pattern.compile("-*\\d+|\\+|\\-");
        Matcher matcher;
        
        for (int i = 0; i < quiz.length; i++) {
            int[] result = new int[4];
            String sign = "";
            matcher = pattern.matcher(quiz[i]);
            
            int j = 0;
            while(matcher.find()) {
                String str = matcher.group();
                
                if (j == 1) sign = str;
                else {
                    if (str.contains("-")) {
                        str = str.replaceAll("- *", "");
                        result[j] = -Integer.parseInt(str.trim());
                    }
                    else result[j] = Integer.parseInt(str.trim());
                }
                j++;
            }
            
            if (sign.equals("+")) answer[i] = (result[3] == result[0] + result[2]) ? "O" : "X";
            else answer[i] = (result[3] == result[0] - result[2]) ? "O" : "X";
        }
        return answer;
    }
}