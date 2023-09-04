import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> countMap = new HashMap<>();
        int answer = 0;
        
        for (int i = 0; i < 10; i ++) 
            countMap.put(discount[i], countMap.getOrDefault(discount[i], 0) + 1);
        
        for (int i = 9; i < discount.length; i++) {
            if (i != 9) {
                countMap.put(discount[i - 10], countMap.get(discount[i - 10]) - 1);
                countMap.put(discount[i], countMap.getOrDefault(discount[i], 0) + 1);
            }
            for (int j = 0; j < want.length; j++) {
                if(number[j] != countMap.getOrDefault(want[j], 0)) break;
                if (j == want.length - 1) answer++;
            }
        }
        return answer;
    }
}