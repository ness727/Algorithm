import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> clothMap = new HashMap<>();
        
        for (String[] cloth : clothes) 
            clothMap.put(cloth[1], clothMap.getOrDefault(cloth[1], 0) + 1);
        return clothMap.values().stream()
            .mapToInt(i -> i + 1)
            .reduce((i, j) -> i * j)
            .getAsInt() - 1;
    }
}