import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> result = new HashMap<>();
        
        for (String[] c : clothes)
            result.put(c[1], result.getOrDefault(c[1], 0) + 1);
        
        return result.values().stream()
            .mapToInt(i -> i + 1)
            .reduce(1, (i, j) -> i * j) - 1;
    }
}