import java.util.Collections;
import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> resultMap = new HashMap<>();
        ArrayList<Integer> resultList = new ArrayList<>();
        
        for (int i = 0; i < tangerine.length; i++)
            resultMap.put(tangerine[i], resultMap.getOrDefault(tangerine[i], 0) + 1);
        resultList.addAll(resultMap.values());
        Collections.sort(resultList, (i, j) -> j - i);
        for (int i = 0; i < resultList.size(); i++) {
            k -= resultList.get(i);
            answer++;
            if (k <= 0) break;
        }
        return answer;
    }
}