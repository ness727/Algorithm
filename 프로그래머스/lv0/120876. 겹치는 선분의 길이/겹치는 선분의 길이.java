import java.util.HashMap;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[][] lines) {
        HashMap<Integer, Integer> numMap = new HashMap<>();
        
        for (int i = 0; i < lines.length; i++)
            for (int j = lines[i][0]; j < lines[i][1]; j++)
                numMap.put(j, numMap.getOrDefault(j, 0) + 1);
        
        return numMap.values().stream().filter(i -> i > 1).collect(Collectors.toList()).size();
    }
}