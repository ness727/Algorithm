import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, ArrayList<String>> result = new HashMap<>();
        
        for (String[] c : clothes) {
            if (!result.containsKey(c[1])) {
                ArrayList<String> newList = new ArrayList<>();
                newList.add(c[0]);
                result.put(c[1], newList);
            } else result.get(c[1]).add(c[0]);
        }
        
        return result.values().stream()
            .mapToInt(list -> list.size() + 1)
            .reduce(1, (i, j) -> i * j) - 1;
    }
}