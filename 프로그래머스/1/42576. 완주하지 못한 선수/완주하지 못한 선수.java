import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> countMap = new HashMap<>();
        
        for (String name : participant) {
            countMap.put(name, countMap.getOrDefault(name, 0) + 1);
        }
        for (String name : completion) {
            countMap.put(name, countMap.getOrDefault(name, 0) - 1);
        }
        return countMap.entrySet().stream()
            .filter(entry -> entry.getValue() == 1)
            .map(entry -> entry.getKey())
            .findFirst()
            .get();
    }
}