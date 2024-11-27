import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] stageCount = new int[N + 2];
        int total = stages.length;
        HashMap<Integer, Float> failureMap = new HashMap<>();
        
        for (int stage : stages) {
            stageCount[stage]++;
        }
        
        for (int i = 1; i <= N; i++) {
            if (stageCount[i] == 0) failureMap.put(i, 0f);
            else {
                failureMap.put(i, (float)stageCount[i] / total);
                total -= stageCount[i];
            }
        }
        
        return failureMap.entrySet().stream()
            .sorted((e1, e2) -> Float.compare(e2.getValue(), e1.getValue()))
            .mapToInt(Map.Entry::getKey)
            .toArray();
    }
}