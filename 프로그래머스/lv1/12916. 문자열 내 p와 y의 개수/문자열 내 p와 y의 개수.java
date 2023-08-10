import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Solution {
    boolean solution(String s) {
        Pattern patternP = Pattern.compile("p|P");
        Pattern patternY = Pattern.compile("y|Y");
        
        return getCount(patternP, s) == getCount(patternY, s);
    }
    
    int getCount(Pattern pattern, String s) {
        int count = 0;
        Matcher matcher = pattern.matcher(s);
        
        while (matcher.find()) {
            matcher.group();
            count++;
        }
        return count;
    }
}