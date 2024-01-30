import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Solution {
    private ArrayList<String> nums = new ArrayList<>();
    private HashSet<Integer> result = new HashSet<>();
    private int num_len;
    
    public int solution(String numbers) {
        int answer = 0;
        num_len = numbers.length();
        
        for (int i = 0; i < num_len; i++)
            nums.add(numbers.substring(i, i + 1));
        for (String strNum : nums)
            result.add(Integer.valueOf(strNum));
        
        for (int i = 0; i < numbers.length(); i++) find(Set.of(i), nums.get(i));
        
        for (Integer num : result) answer += isPrime(num);
        
        return answer;
    }
    
    private void find(Set<Integer> paramIndexes, String num) {
        for (int i = 0; i < nums.size(); i++) {
            HashSet<Integer> indexes = new HashSet<>();
            indexes.addAll(paramIndexes);
            if (indexes.contains(i)) continue;
            
            String strNum = num + nums.get(i);
            result.add(Integer.valueOf(strNum));
            indexes.add(i);
            if (strNum.length() < num_len) find(indexes, strNum);
        }
    }
    
    private static int isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return 0;
        }
        return (num > 1) ? 1 : 0;
    }
}