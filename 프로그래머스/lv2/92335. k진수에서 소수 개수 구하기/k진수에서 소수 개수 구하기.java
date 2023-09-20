import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        Pattern pat = Pattern.compile("[1-9]+");
        Matcher mat = pat.matcher(Integer.toString(n, k));
        
        while (mat.find()) {
            long num = Long.parseLong(mat.group());
            if (num != 1) answer += isPrime(num) ? 1 : 0;
        }
        return answer;
    }
    
    public boolean isPrime(long num) {
        int result = 0;
        
        for (long i = 1; i <= Math.sqrt(num); i++)
            if (num % i == 0) result++;
        return result == 1 ? true : false;
    }
}