import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] array) {
        int[] answer;
        HashMap<Integer, Integer> result = new HashMap<>();
        
        for (int i : array) result.put(i, result.getOrDefault(i, 0) + 1);
        answer = result.entrySet().stream().sorted((e1, e2) -> e2.getValue() - e1.getValue())
            .limit(2).mapToInt(Map.Entry::getKey).toArray();
        
        if (answer.length == 2)
            if (result.get(answer[0]) == result.get(answer[1])) return -1;
        return answer[0];
    }
}