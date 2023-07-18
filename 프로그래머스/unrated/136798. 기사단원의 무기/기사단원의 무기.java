import java.util.HashSet;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        HashSet<Integer> countSet = new HashSet<>();
        
        for (int i = 2; i <= number; i++) {
            countSet.clear();
            for (int j = 1; j <= Math.sqrt(i); j++) 
                if (i % j == 0) {
                    countSet.add(j);
                    countSet.add(i / j);
                }
            answer += (countSet.size() > limit) ? power : countSet.size();
        }
        return answer + 1;
    }
}